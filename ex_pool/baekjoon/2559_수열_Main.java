import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Bj 2559.수열
// 22652 kb
// 1032 ms
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] temperature = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			temperature[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = Integer.MIN_VALUE;
		for (int i = 0; i <= N-K; i++) {
			int sum = 0;
			for (int j = i; j < i+K; j++) {
				sum += temperature[j]; 
			}
			answer = Math.max(answer, sum);
		}
		System.out.println(answer);
	}
}
