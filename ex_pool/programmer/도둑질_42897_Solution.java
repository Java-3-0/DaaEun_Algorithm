public class 도둑질_42897_Solution {
	
	public int solution(int[] money) {
        int answer = 0;
        int N = money.length;
        
        //[훔친여부][0:안훔침 1:훔침][N]
        int[][][] dp = new int[2][2][N];
        
        dp[0][0][0] = 0;
        dp[0][1][0] = 0;
        
        dp[1][0][0] = 0;
        dp[1][1][0] = money[0];
        
        for (int i = 1; i < N; i++) {
        	for (int j = 0; j < 2; j++) {
        		dp[j][0][i] = Math.max(dp[j][0][i-1], dp[j][1][i-1]);
        		dp[j][1][i] = dp[j][0][i-1] + money[i];
			}
		}

        answer = Math.max(Math.max(dp[0][0][N-1], dp[0][1][N-1]), dp[1][0][N-1]);
        return answer;
    }
}
