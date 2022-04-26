import java.util.Scanner;

// 12888 kb
// 112 ms
public class 돌게임4_9658_Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
//		boolean[] dp = new boolean[N+1];
//		
//		// false : CY
//		// true : SK
//		dp[1] = false;
//		dp[2] = true;
//		dp[3] = false;
//		dp[4] = true;
//		
//		for (int i = 5; i <= N; i++) {
//			
//			if(dp[i-1] && dp[i-3] && dp[i-4]) dp[i] = false;
//			else dp[i] = true;
//		}
//
//		for (int i = 1; i <= N; i++) {
//			System.out.println(i + " : " + dp[i]);
//		}
//		
//		if(dp[N]) System.out.println("SK");
//		else System.out.println("CY");
		
		if(N % 7 == 1 || N % 7 == 3) System.out.println("CY");
		else System.out.println("SK");
		
		sc.close();
	}
}