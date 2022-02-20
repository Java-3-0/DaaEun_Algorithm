import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// BJ 15650.N과 M (2)
// 11568 kb
// 80 ms
public class Main {
	
	static int N, M;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		combination(0, 1);
		System.out.println(sb.toString());
	}
	
	public static void combination(int cnt, int start) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i <= N; i++) {
			numbers[cnt] = i;
			combination(cnt+1, i+1);
		}
	}
}
