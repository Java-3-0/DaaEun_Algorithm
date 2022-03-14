import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
		StringBuffer sb = new StringBuffer();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(bf.readLine());
		
		StringTokenizer st = null;
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][N];
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(bf.readLine(), " ");
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append("#" + tc + " " + getFly(N, M, map) + "\n");
		} // for(tc)-end
		System.out.println(sb);
	}

	private static int getFly(int N, int M, int[][] map) {
		
		int killFlyMax = 0;
		
		for (int startR = 0; startR <= N - M; startR++) { // endR = N - M
			for (int startC = 0; startC <= N - M; startC++) { // endC = N - M
				int killFlyCnt = 0;
				for (int i = startR; i < startR+M; i++) {
					for (int j = startC; j < startC+M; j++) {
						killFlyCnt += map[i][j];
					}  // for(j)-end
				}  // for(i)-end
				killFlyMax = Math.max(killFlyCnt, killFlyMax);
			}  // for(startC)-end
		} // for(startR)-end
		
		return killFlyMax;
	}
}