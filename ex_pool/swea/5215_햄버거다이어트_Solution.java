import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution {

	static int N, L, maxTaste;
	static int[] taste, calory;

	public static void main(String[] args) throws Exception {
		
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			taste = new int[N];
			calory = new int[N];
			maxTaste = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				taste[i] = Integer.parseInt(st.nextToken());
				calory[i] = Integer.parseInt(st.nextToken());
			}
			burgerDiet(0, 0, 0);
			sb.append("#" + t + " " + maxTaste + "\n");
		} // for(t) - end
		System.out.println(sb.toString());
	}
	public static void burgerDiet(int cnt, int tasteSum, int calorySum) {
		
		if(calorySum > L) return;
		if(cnt == N && calorySum <= L) {
			maxTaste = tasteSum > maxTaste ? tasteSum : maxTaste;
			return;
		}
		
		calorySum += calory[cnt];
		tasteSum += taste[cnt];
		burgerDiet(cnt+1, tasteSum, calorySum);
		calorySum -= calory[cnt];
		tasteSum -= taste[cnt];
		burgerDiet(cnt+1, tasteSum, calorySum);
	}
}