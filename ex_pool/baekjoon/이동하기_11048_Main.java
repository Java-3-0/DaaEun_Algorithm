import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 81836 kb
// 476 ms
public class 이동하기_11048_Main {
	
	static int[] dr = {1, 0, 1};
	static int[] dc = {0, 1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] maze = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < M; c++) {
				maze[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] candy = new int[N][M];
		candy[0][0] = maze[0][0];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				for (int d = 0; d < 3; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
					candy[nr][nc] = Math.max(candy[nr][nc], candy[r][c] + maze[nr][nc]);
				}
			}
		}
		System.out.println(candy[N-1][M-1]);
	}
}
