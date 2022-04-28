import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 14676 kb
// 96 ms
public class 양팔저울_2629_Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 추 갯수와 무게 입력받기
		int M = Integer.parseInt(br.readLine());
		int[] mArr = new int[M]; 
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			mArr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 구슬 갯수와 무게 입력받기
		int N = Integer.parseInt(br.readLine());
		int[] nArr = new int[N]; 
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			nArr[i] = Integer.parseInt(st.nextToken());
		}		
		
		// M x 500 : 최대가능한 무게
		int end = M*500 + 1;
		boolean[][] dp = new boolean[M][40001];
		dp[0][mArr[0]] = true;
		for (int i = 1; i < M; i++) {
			dp[i][mArr[i]] = true;
			for (int j = 0; j < end; j++) {
				if(dp[i-1][j]) {
					dp[i][j] = true;
					if(j + mArr[i] > 0) dp[i][j + mArr[i]] = true;
					if(j - mArr[i] > 0)	dp[i][j - mArr[i]] = true;
					if(mArr[i] - j > 0)	dp[i][mArr[i] - j] = true;
				}
			}
		}
		
		// 결과 도출
		for (int i = 0; i < N; i++) {
			if(dp[M-1][nArr[i]]) sb.append("Y ");
			else sb.append("N ");
		}
		
		// 정답 출력하기
		System.out.println(sb.toString());
	}
}
