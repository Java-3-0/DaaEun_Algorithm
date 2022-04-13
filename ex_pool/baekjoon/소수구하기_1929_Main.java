import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 17740 kb
// 392 ms
public class Main_1929_소수구하기_양다은 {
	
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		for (int i = M; i <= N; i++) {
			if(i == 1) continue;
			if(i == 2 || i == 3) sb.append(i).append("\n");
			else {
				boolean flag = true;
				for (int j = 2; j <= Math.sqrt(i); j++) {
					if(i % j == 0) {
						flag = false;
						break;
					}
				}
				if(flag) sb.append(i).append("\n");
			}
			
		}
		System.out.println(sb.toString());
	}
}
