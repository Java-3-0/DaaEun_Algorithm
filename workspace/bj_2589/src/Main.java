import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BJ 2589.보물섬
// 292668 kb
// 508 ms
public class Main {
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {1, -1, 0, 0};
	
	static int R, C, answer;
	static char[][] map;
	static int[][] isVisited;
	static Queue<int[]> queue = new LinkedList<int[]>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for (int r = 0; r < R; r++) {
			char[] str = br.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				map[r][c] = str[c];
			}
		}
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c] == 'L') {
					isVisited = new int[R][C];
					bfs(r, c, 0);
				}
			}
		}
		System.out.println(answer - 1);
	}
	
	public static void bfs(int r, int c, int t) {
		queue.offer(new int[] {r, c});
		isVisited[r][c] = 1;
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = temp[0] + dr[i];
				int nc = temp[1] + dc[i];
				
				if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == 'W' || isVisited[nr][nc] != 0) continue;
				
				queue.offer(new int[] {nr, nc});
				isVisited[nr][nc] = isVisited[temp[0]][temp[1]] + 1;
				answer = Math.max(answer, isVisited[nr][nc]);
				
			}
//			for (int i = 0; i < R; i++) {
//				System.out.println(Arrays.toString(isVisited[i]));
//			}
//			System.out.println();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
