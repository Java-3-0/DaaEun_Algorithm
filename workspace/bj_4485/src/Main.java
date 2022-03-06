import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BJ 4485.녹색 옷 입은 애가 젤다지?
// kb
// ms
public class Main {
	
	static int N;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = 1;
		while((N = Integer.parseInt(br.readLine())) != 0){
			int kRupee = 0;
			int[][] cave = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//prim 알고리즘
			ㄴ
			
			sb.append("Problem " + tc++ + ": " + kRupee + "\n");
		}
		System.out.println(sb.toString());
	}
}
