import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 멀티탭스케줄링_1700_Main {

	static int N, K, cnt;
	static int[] product, adaptor;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		product = new int[K];
		adaptor = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int k = 0; k < K; k++) {
			product[k] = Integer.parseInt(st.nextToken());
		}
		for (int n = 0; n < N; n++) {
			adaptor[n] = product[n];
		}
		
	}
	
	public static void use(int start) {
		
		for (int n = 0; n < N; n++) {
			if(adaptor[n] == product[start]) use(start+1);
		}
		
		boolean[] isSelected = new boolean[N];
		for (int i = start+1; i < start+N; i++) {
			for (int n = 0; n < N; n++) {
				if(adaptor[n] == product[i] ) {
					isSelected[n] = true;
					adaptor[n] = product[i];
					cnt++;
					use(i+1);
				}
					
			}
		}
	}
}
