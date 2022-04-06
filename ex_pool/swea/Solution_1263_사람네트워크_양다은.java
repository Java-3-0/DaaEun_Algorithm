import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 98,300 kb
// 3,930 ms
public class Solution_1263_사람네트워크_양다은 {
	
	static int N;
	static int[][] adjMatrix;
	static final int INF = 9999999;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			adjMatrix = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					adjMatrix[r][c] = Integer.parseInt(st.nextToken());
					if(r != c && adjMatrix[r][c] == 0) adjMatrix[r][c] = INF;
				}
			}
			
			for (int k = 0; k < N; k++) {	//경유지
				for (int i = 0; i < N; i++) {	//출발지
					if(i==k) continue;
					for (int j = 0; j < N; j++) {	//도착지
						if(i==j || k==j) continue;
						if(adjMatrix[i][j] > adjMatrix[i][k]+adjMatrix[k][j]) {
							adjMatrix[i][j] = adjMatrix[i][k]+adjMatrix[k][j];
						}
					}
				}
			}
			
			int minCC = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += adjMatrix[i][j];
				}
				minCC = Math.min(minCC, sum);
			}
			sb.append("#" + tc + " " + minCC + "\n");
		}//for tc end
		System.out.println(sb.toString());
	}
}
