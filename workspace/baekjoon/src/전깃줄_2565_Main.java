import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 전깃줄_2565_Main {
	
	static int[] overLine = new int[501];
	
	static class line implements Comparable<line>{
		int a, b;

		public line(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] pole = new int[N][2];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			pole[n][0] = Integer.parseInt(st.nextToken());
			pole[n][1] = Integer.parseInt(st.nextToken());
			for (int i = ; i < pole.length; i++) {
				
			}
		}
		
		for (int i = 0; i < overLineCnt.length; i++) {
			
		}
		
	}
}
