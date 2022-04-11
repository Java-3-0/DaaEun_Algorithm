import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 27312 kb
// 125 ms
public class Solution_5607_조합_양다은 {
	
	static int N, R;
	final static long MOD = 1234567891;
	final static long MOD2 = 1234567889;
	static long[] cache = new long[1000001];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			func1(N);
			
			long answer = ((cache[N] * func2(cache[N-R], MOD2)) % MOD * func2(cache[R], MOD2)) % MOD;
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void func1(int n) {
		
		cache[1] = 1;
		for (int i = 2; i <= n; i++) {
			if(cache[i] != 0) continue;
			cache[i] = cache[i-1] * i % MOD;
		}
	}
	
	public static long func2(long x, long y) {
		
		if(y == 0) return 1;
		if(y == 1) return x;

//		System.out.println("x : " + x  + ", y : " + y);
		long tmp = func2(x, y/2) % MOD;
		if(y % 2 == 0) return (tmp * tmp) % MOD;
		else return ((tmp * tmp) % MOD * x) % MOD;
	}
}
