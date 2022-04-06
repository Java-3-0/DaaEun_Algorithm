import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// kb
// ms
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
		
		int[][] minCost = new int[3][N];
		minCost[0][0] = house[0][0];
		minCost[1][0] = house[0][1];
		minCost[2][0] = house[0][2];

		
		for (int n = 1; n < N-1; n++) {
			minCost[0][n] = Math.min(minCost[1][n-1], minCost[2][n-1]) + house[n][0];
			minCost[1][n] = Math.min(minCost[0][n-1], minCost[2][n-1]) + house[n][1];
			minCost[2][n] = Math.min(minCost[0][n-1], minCost[1][n-1]) + house[n][2];
		}
//		System.out.println(Arrays.toString(minCost[0]));
//		System.out.println(Arrays.toString(minCost[1]));
//		System.out.println(Arrays.toString(minCost[2]));
		System.out.println(Math.min(Math.min(minCost[0][N-1], minCost[1][N-1]), minCost[2][N-1]));
	}
}
