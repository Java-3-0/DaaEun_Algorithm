import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치_2110_Main {
	
	static int N, C;
	static int[] pos;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		pos = new int[N];
		for (int n = 0; n < N; n++) {
			pos[n] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(pos);
		/*
		 * 
		 */
		
	}
}
