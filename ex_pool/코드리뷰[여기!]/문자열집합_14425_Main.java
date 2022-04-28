import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 38452 kb
// 4552 ms
public class 문자열집합_14425_Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] S = new String[N];
		for (int i = 0; i < N; i++) {
			S[i] = br.readLine();
		}
		
		int answer = 0;
		String str = null;
		for (int i = 0; i < M; i++) {
			str = br.readLine();
			for (int j = 0; j < N; j++) {
				if(str.equals(S[j])) {
					answer++;
					break;
				}
			}
		}
		System.out.println(answer);
	}
}
