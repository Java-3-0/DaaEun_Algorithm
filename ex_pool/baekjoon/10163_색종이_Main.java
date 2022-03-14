import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BJ 10163.색종이
// 20176 kb
// 240 ms
public class Main {
	
	static int[][] paper = new int[1001][1001];
	static int[] isVisibled;
	static int minR = Integer.MAX_VALUE, minC = Integer.MAX_VALUE;
	static int maxR, maxC;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		isVisibled = new int[N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			minR = Math.min(minR, x);
			minC = Math.min(minC, y);
			maxR = Math.max(maxR, x+width-1);
			maxC = Math.max(maxC, y+height-1);
			
			for (int r = x; r < x+width; r++) {
				for (int c = y; c < y+height; c++) {
					paper[r][c] = i;
				}
			}
		}
		
		for (int r = minR; r <= maxR; r++) {
			for (int c = minC; c <= maxC; c++) {
				isVisibled[paper[r][c]]++;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			sb.append(isVisibled[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
}