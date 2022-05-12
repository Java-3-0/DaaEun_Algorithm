import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 778782 kb
// 400 ms
public class 피리부는사나이_16724_Main {
	
	// 상 하 좌 우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		for (int r = 0; r < R; r++) {
			char[] str = br.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				switch (str[c]) {
				case 'U': map[r][c] = 0; break;
				case 'D': map[r][c] = 1; break;
				case 'L': map[r][c] = 2; break;
				case 'R': map[r][c] = 3; break;
				}
			}
		}
		
		int answer = 0;
		int curR, curC, nr, nc;
		Queue<int[]> queue = new LinkedList<int[]>();
		int[][] isSelected = new int[R][C];	// 0: 지나지 않음, 1: 지남, 2: SAFE ZONE
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(isSelected[r][c] != 0) continue;
				isSelected[r][c] = 1;
				curR = r;
				curC = c;
				queue.add(new int[] {curR, curC});
				while(true) {
					nr = curR + dr[map[curR][curC]];
					nc = curC + dc[map[curR][curC]];
					// 지난 경로인 경우
					if(isSelected[nr][nc] == 1) {
//						isSelected[curR][curC] = 2;
						answer++;
						break;
					}
					// SAFE ZONE 영역인 경우
					if(isSelected[nr][nc] == 2) {
						break;
					}
					// 지나지 않은 경로인 경우
					isSelected[nr][nc] = 1;
					queue.add(new int[] {nr, nc});
					curR = nr;
					curC = nc;
				}
				
				while(!queue.isEmpty()) {
					int[] arr = queue.poll();
					int tr = arr[0];
					int tc = arr[1];
					isSelected[tr][tc] = 2;
				}
				
//				for (int k = 0; k < R; k++) {
//					System.out.println(Arrays.toString(isSelected[k]));
//				}
//				System.out.println();
			}
		}
		
		System.out.println(answer);
	}
}
