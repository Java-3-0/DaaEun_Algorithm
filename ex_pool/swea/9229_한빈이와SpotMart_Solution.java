import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] snacks;
	static int N, M, maxSum;
	
	public static void main(String[] args) throws Exception {
		
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine(), " "); 
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			maxSum = 0;
			
			snacks = new int[N];
			st = new StringTokenizer(br.readLine(), " "); 
			for (int i = 0; i < N; i++) {
				snacks[i] = Integer.parseInt(st.nextToken());
			}
			maxTwoSnacks(0, 0, 0);
			sb.append("#" + tc + " " + maxSum + "\n");
		}
		System.out.println(sb.toString());
	}
	private static void maxTwoSnacks(int cnt, int idx, int snackSum) {	
		if(snackSum > M) return;
		if(cnt == 2 && snackSum <= M) {
			maxSum = snackSum > maxSum ? snackSum : maxSum;
			return;
		}
		if(idx == N) {
			if(maxSum == 0)	maxSum = -1;
			return;
		}
		snackSum += snacks[idx];
		maxTwoSnacks(cnt+1, idx+1, snackSum);
		snackSum -= snacks[idx];
		maxTwoSnacks(cnt, idx+1, snackSum);
	}
}