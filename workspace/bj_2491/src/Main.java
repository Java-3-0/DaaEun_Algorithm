import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BJ 2491.수열
// 21188 kb
// 188 ms
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(N == 1) {
			System.out.println(1);
			return;
		}

		int maxLength = 0;
		int start = 0;
		while (start < N - 1) {
			int cnt = 1;
			for (int i = start; i < N - 1; i++) {
				if (arr[i] <= arr[i + 1]) {
					cnt++;
					if(i+1 == N-1) {
						start = i+1;
						break;
					}
				}
				else {
					start = i+1;
					break;
				}
			}
			maxLength = Math.max(maxLength, cnt);
		}
		start = N-1;
		while (start > 0) {
			int cnt = 1;
			for (int i = start; i > 0; i--) {
				if (arr[i] <= arr[i-1]) {
					cnt++;
					if(i-1 == 0) {
						start = i-1;
						break;
					}
				}
				else {
					start = i-1;
					break;
				}
			}
			maxLength = Math.max(maxLength, cnt);
		}
		System.out.println(maxLength);
	}
}
