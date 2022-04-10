import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 12484 kb
// 84 ms
public class 전깃줄_2565_Main {
	
	static class Line implements Comparable<Line>{
		int a, b;

		public Line(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Line o) {
			return this.a - o.a;
		}
	}
	
	static int N;
	static Line[] line;
	static int[][] cache;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		line = new Line[N];
		cache = new int[N][501];
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			line[n] = new Line(a, b);
		}
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(cache[i], -1);
		}
		Arrays.sort(line);
		System.out.println(dp(0, 0));
	}
	
	public static int dp(int lineIdx, int lastConnected) {
		
		if(lineIdx == N) return 0;
		
		if(cache[lineIdx][lastConnected] != -1)	return cache[lineIdx][lastConnected];
		
		int b = line[lineIdx].b;
		
		// 선을 자르는 경우
		int ret = 1 + dp(lineIdx+1, lastConnected);
		
		// 선을 자르지 않는 경우
		if(b >lastConnected) ret = Math.min(ret, dp(lineIdx+1, b));
		
		return cache[lineIdx][lastConnected] = ret;
	}
}
