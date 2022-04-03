import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// kb
// ms
public class 포도주시식_2156_Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] wine = new int[N+1];
		for (int n = 0; n < N; n++) {
			wine[n] = Integer.parseInt(br.readLine());
		}
		
		int[] maxWine = new int[N+1];
		maxWine[0] = 0;
		maxWine[1] = wine[1];
		maxWine[2] = wine[0] + wine[1];
		maxWine[3] = Math.max(maxWine[2], wine[1] + wine[2]);
		for (int n = 4; n <= N; n++) {
			
			int max = 0;
			
		}
	}
}
