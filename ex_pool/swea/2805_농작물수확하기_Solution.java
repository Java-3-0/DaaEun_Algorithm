import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	static int N;
	static char[][] farm;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			farm = new char[N][N];
			for (int r = 0; r < N; r++) {
				farm[r] = br.readLine().toCharArray();
			}
			
			sb.append("#" + tc + " " + growCrop(0) + "\n");
		}
		System.out.println(sb.toString());
	}
	private static int growCrop(int cropSum) {
		
		int turn = 0;
		for (int r = 0; r < N; r++) {
			for (int c = Math.abs(N/2-r); c <= N/2 + turn; c++) {
				cropSum += (int) farm[r][c] -'0';
			}
			if(r >= N/2) {
				turn--;
			}else {
				turn++;
			}
		}
		return cropSum;
	}
}