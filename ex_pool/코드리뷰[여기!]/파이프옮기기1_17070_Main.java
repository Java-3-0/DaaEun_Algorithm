import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11644 kb
// 76 ms
public class 파이프옮기기1_17070_Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
	
		// 0: 가로, 1: 대각선, 2: 세로
		int[][][] dp = new int[3][N][N];
		// 초기화
		dp[0][0][1] = 1;
		for (int c = 2; c < N; c++) {
			for (int r = 0; r < N; r++) {
				
				if(map[r][c] == 1) continue;
				
				// 가로 파이프
				dp[0][r][c] = dp[0][r][c-1] + dp[1][r][c-1];
				
				if(r-1 >= 0) {
					// 대각선 파이프
					if(map[r-1][c] == 0 && map[r][c-1] == 0) {	//45도만 회전가능
						dp[1][r][c] = dp[0][r-1][c-1] + dp[1][r-1][c-1] + dp[2][r-1][c-1];
					}
					// 세로 파이프
					dp[2][r][c] = dp[1][r-1][c] + dp[2][r-1][c];
				}
			}//for r end
		}//for c end
		
		System.out.println(dp[0][N-1][N-1] + dp[1][N-1][N-1] + dp[2][N-1][N-1]);
		
	}
}
