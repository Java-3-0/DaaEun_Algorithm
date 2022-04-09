import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 12108 kb
// 88 ms
public class RGB거리2_17404_Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] house = new int[N][3];
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			house[n][0] = Integer.parseInt(st.nextToken());
			house[n][1] = Integer.parseInt(st.nextToken());
			house[n][2] = Integer.parseInt(st.nextToken());
		}
		
		// [1번 집의 색][rgb][N]
		int[][][] minCost = new int[3][3][N];
		
		// r : 0
		minCost[0][0][0] = house[0][0];
		minCost[0][1][0] = 1001;
		minCost[0][2][0] = 1001;
		
		// g : 1
		minCost[1][0][0] = 1001;
		minCost[1][1][0] = house[0][1];
		minCost[1][2][0] = 1001;
		
		// b : 2
		minCost[2][0][0] = 1001;
		minCost[2][1][0] = 1001;
		minCost[2][2][0] = house[0][2];
		
		for (int n = 1; n < N; n++) {
			for (int i = 0; i < 3; i++) {
				minCost[i][0][n] = Math.min(minCost[i][1][n-1], minCost[i][2][n-1]) + house[n][0];
				minCost[i][1][n] = Math.min(minCost[i][0][n-1], minCost[i][2][n-1]) + house[n][1];
				minCost[i][2][n] = Math.min(minCost[i][0][n-1], minCost[i][1][n-1]) + house[n][2];
			}
		}
		System.out.println(CalcMin(minCost[0][1][N-1], minCost[0][2][N-1], minCost[1][0][N-1], minCost[1][2][N-1], minCost[2][0][N-1], minCost[2][1][N-1]));
	}
	
	public static int CalcMin(int a, int b, int c, int d, int e, int f) {
		
		int n1 = Math.min(a, b);
		int n2 = Math.min(c, d);
		int n3 = Math.min(e, f);
		
		return Math.min(Math.min(n1, n2), n3);
	}
}
