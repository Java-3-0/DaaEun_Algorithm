import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BJ 2669.직사각형 네개의 합집합의 면적 구하기
// 11536 kb
// 76 ms
public class Main {
	
	static int[][] map = new int[100][100];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
	
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for (int r = x1; r < x2; r++) {
				for (int c = y1; c < y2; c++) {
					if(map[r][c] == 0) {
						map[r][c] = 1;
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
