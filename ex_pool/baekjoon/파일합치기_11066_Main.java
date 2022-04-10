import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파일합치기_11066_Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < TC; tc++) {
			
			int K = Integer.parseInt(br.readLine());
			int[] file = new int[K];
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int k = 0; k < K; k++) {
				file[k] = Integer.parseInt(st.nextToken());
			}
			
//			int[][] dp = new int[][];
			
			int answer = 0;
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}
