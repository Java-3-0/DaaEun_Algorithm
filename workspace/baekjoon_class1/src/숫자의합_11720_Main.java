import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 11496 kb
// 76 ms
public class 숫자의합_11720_Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] str = br.readLine().toCharArray();
		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer += str[i] - '0';
		}
		
		System.out.println(answer);
	}
}
