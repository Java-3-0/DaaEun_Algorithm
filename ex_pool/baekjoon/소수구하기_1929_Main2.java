
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 18516 kb
// 192 ms
public class Main_1929_소수_양다은2 {
	
	static int M, N;
	static int[] sieve;
	
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		primeSieve();
		for (int i = M; i <= N; i++) {
			if(isPrime(i)) sb.append(i).append("\n");
		}
		System.out.println(sb.toString());
	}

	
	public static void primeSieve() {
	
		sieve = new int[N/8 + 1];
		Arrays.fill(sieve, 255);
		setComposite(0);
		setComposite(1);
		
		int end = (int) Math.sqrt(N);
		for (int i = 2; i <= end; i++) {
			if(isPrime(i)) {
				for (int j = i*i; j <= N; j+=i) {
					setComposite(j);
				}
			}
		}
	}
	
	public static void setComposite(int k) {
		sieve[k >>> 3] &= ~ (1 << (k & 7));
	}
	
	public static boolean isPrime(int k) {
		return (sieve[k >>> 3] & (1 << (k & 7))) != 0;
	}
}

