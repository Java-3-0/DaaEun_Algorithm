import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, answer;
	static int[] brand;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		brand = new int[N];
		for (int i = 0; i < N; i++) {
			brand[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(brand);
		getK(1, 0);
		System.out.println(answer);
	}
	
	private static void getK(int cnt, int start) {
		
		if(start == N) return;
		
		for (int i = start; i < N; i++) {
			if(brand[start] == cnt) {
				answer++;
				System.out.println("start :" + start + ", cnt : " + cnt);
				if(start+1 < N && brand[start+1] == cnt) getK(cnt, start+1);
				else getK(cnt+1, start+1);
			} else {
				return;
			}
			
		}
		
		
		
		
		
		
	}
}
