import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AB5_10952_Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = 0, B = 0;
		while(true) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			if(A == 0) break;
			sb.append(A+B).append("\n");
		}
		System.out.println(sb.toString());
	}
}
