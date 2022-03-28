import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// kb
// ms
public class 나무재테크_16235_Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] food = new int[N][N];
		for(int[] f : food) {
			Arrays.fill(f, 5);
		}
		
		int[][] A = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < N; c++) {
				A[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] tree = new int[M][3];
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 3; i++) {
				tree[m][i] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for (int k = 0; k < K; k++) {
		
			//봄
			
			//여름
			//가을
			//겨울
		}
	}
}
