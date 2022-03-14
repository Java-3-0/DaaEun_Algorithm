import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA 1247. 최적 경로
public class Solution {

	static int N, minDistance; 
	static int[] company = new int[2];
	static int[] home = new int[2];
	static int[][] client, visitOrder;
	static boolean[] isVisited;
	
	public static void main(String[] args) throws Exception {

		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine(), " ");
			company[0] = Integer.parseInt(st.nextToken());	// company x
			company[1] = Integer.parseInt(st.nextToken());	// company y
			home[0] = Integer.parseInt(st.nextToken());		// home x
			home[1] = Integer.parseInt(st.nextToken());		// home y
			
			client = new int[N][2];
			visitOrder = new int[N][2];
			isVisited = new boolean[N];
			for (int i = 0; i < N; i++) {
				client[i][0] = Integer.parseInt(st.nextToken());	// client x
				client[i][1] = Integer.parseInt(st.nextToken());	// client y
			}
			
			minDistance = Integer.MAX_VALUE;
			meetNextClient(0);
			sb.append("#" + tc + " " + minDistance + "\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void meetNextClient(int cnt) {
		
		if(cnt == N) {
			CalculateDistance(0);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(isVisited[i]) continue;
			
			visitOrder[cnt] = client[i];
			isVisited[i] = true;
			
			meetNextClient(cnt+1);
			isVisited[i] = false;
		}
	}

	public static void CalculateDistance(int distance) {
		
		int startX = company[0];
		int startY = company[1];
		for (int i = 0; i < N; i++) {
			distance += Math.abs(startX - visitOrder[i][0]) + Math.abs(startY - visitOrder[i][1]);
			startX = visitOrder[i][0];
			startY = visitOrder[i][1];
		}
		distance += Math.abs(startX - home[0]) + Math.abs(startY - home[1]);
		minDistance = distance < minDistance ? distance : minDistance;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}