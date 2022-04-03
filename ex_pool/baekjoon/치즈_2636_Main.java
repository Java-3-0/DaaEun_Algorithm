import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 14244 kb
// 124 ms
public class Main_2636_치즈 {
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static int R, C, cheeseCnt;
	static int[][] cheese;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		cheese = new int[R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < C; c++) {
				cheese[r][c] = Integer.parseInt(st.nextToken());
				if(cheese[r][c] == 1) cheeseCnt++;
			}
		}
		melted(0, 0);
	}
	
	public static void melted(int time, int preCnt) {

		if(cheeseCnt == 0) {
			System.out.println(time + "\n" + preCnt);
			return;
		}
		
		bfs();
		
		int cnt = 0;
		for (int r = 1; r < R-1; r++) {
			for (int c = 1; c < C-1; c++) {
				if(cheese[r][c] == 1) {
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						
						if(cheese[nr][nc] == -1) {
							cheese[r][c] = 2;
							cnt++;
							cheeseCnt--;
							break;
						}
					}//for d end
				}
			}//for c end
		}//for r end
		
		for (int r = 1; r < R-1; r++) {
			for (int c = 1; c < C-1; c++) {
				if(cheese[r][c] == 2) {
					cheese[r][c] = -1;
				}
			}	
		}
		
//		for (int r = 0; r < R; r++) {
//			for (int c = 0; c < C; c++) {
//				System.out.print(cheese[r][c] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		melted(++time, cnt);
	}
	
	public static void bfs() {
		boolean[][] isVisited = new boolean[R][C];
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {0, 0});
		isVisited[0][0] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curR = cur[0];
			int curC = cur[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];
				
				if(nr<0 || nr>=R || nc<0 || nc>=C || cheese[nr][nc]==1 || isVisited[nr][nc]) continue;
				
				cheese[nr][nc] = -1;
				isVisited[nr][nc] = true;
				queue.offer(new int[] {nr, nc});
			}//for d end
		}//while end
	}
}
