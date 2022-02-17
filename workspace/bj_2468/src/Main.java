import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Bj 2468.안전영역
// 55464 kb
// 256 ms
public class Main {
	
	// 상 하 좌 우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N, answer;
	static int[][] region;	// 지역 높이
	static int[][] board;	// 방문
	static Queue<int[]> queue = new LinkedList<int[]>();
	
	public static void main(String[] args) throws Exception {
		
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		region = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < N; c++) {
				region[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		getSafeZone();
		System.out.println(answer);
	}
	
	public static void getSafeZone() {
		
		for (int i = 0; i < 100; i++) {
			int sum = 0;
			board = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(region[r][c] > i && board[r][c] == 0) {
						bfs(r, c, i);
						sum++;
					}
				}
			}
//			System.out.println("i : " + i + ", sum : " + sum);
			if(sum == 0) break;
			answer = sum > answer ? sum : answer;
		}
	}
	
	public static void bfs(int r, int c, int rainH) {
//		System.out.println("****************");
		queue.offer(new int[] {r, c});
		board[r][c] = 1;
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
//			System.out.println(temp[0] + ", " + temp[1] + ", " + board[temp[0]][temp[1]]);
			for (int i = 0; i < 4; i++) {
				int nr = temp[0] + dr[i];
				int nc = temp[1] + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || region[nr][nc] <= rainH || board[nr][nc] == 1) continue;
				
				queue.offer(new int[] {nr, nc});
				board[nr][nc] = 1;
			} // for-end
		} // while-end
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
