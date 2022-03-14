import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BJ 11404.플로이드
// 45220 kb
// 500 ms

// 플로이드 와샬 알고리즘

// # 임도형 아이디어 : Integer.MAX_VALUE을 천만 이상의 값으로 정의, 오버플로우 방지
// 				 static int max = 987654321;
// 근뎈ㅋㅋㅋㅋㅋㅋㅋ 49052 kb, 592 ms 더 증가했넹ㅋㅋㅋㅋ
public class Main {
	
	static int[][] distance;
//	static int max = 987654321;
	
	public static void main(String[] args) throws Exception {
		
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
 		distance = new int[n+1][n+1];
 		
 		for (int r = 1; r <= n; r++) {
 			for (int c = 1; c <= n; c++) {
 				if(r == c) continue;
 				distance[r][c] = Integer.MAX_VALUE;
 			}
 		}
 		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(distance[a][b] != Integer.MAX_VALUE && distance[a][b] < c) {
				continue;
			}
			distance[a][b] = c;
		}
		
		// 플로이드 와샬
		for (int i = 1; i <= n; i++) {
			for (int r = 1; r <= n; r++) {
				for (int c = 1; c <= n; c++) {
					if(distance[r][i] == Integer.MAX_VALUE || distance[i][c] == Integer.MAX_VALUE) {
						continue;
					}
					if(distance[r][c] > distance[r][i] + distance[i][c]) {
						distance[r][c] = distance[r][i] + distance[i][c];
					}
				}
			}
		}// for i end - 알고리즘
		
		for (int r = 1; r <= n; r++) {
			for (int c = 1; c <= n; c++) {
				if(distance[r][c] >= Integer.MAX_VALUE) distance[r][c] = 0;
				System.out.print(distance[r][c] + " ");
			}
			System.out.println();
		}
	}
}
