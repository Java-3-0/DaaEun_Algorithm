import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BJ 14890.경사로
// 12788 kb
// 104 ms
public class Main2 {
	
	static int N, L, iCanGoCnt;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		int[][] map2 = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				map2[j][i] = map[i][j];
			}
		}
		canGo(map);
		canGo(map2);
		System.out.println(iCanGoCnt);
	}
	public static void canGo(int[][] map) {
		
		
		for (int r = 0; r < N; r++) {
			
			isSelected = new boolean[N];
			int idx = 1;
			int preHigh = map[r][0];
			boolean iCanGo = true;
			
			LOOP : for (int c = idx; c < N; c++) {
				if(Math.abs(preHigh - map[r][c]) > 1) {
					iCanGo = false;
					break LOOP;
				}
				if(preHigh < map[r][c]) {			// 오르막 경사로를 놓아야 하는 경우
					for (int i = 1; i <= L; i++) {
						if(c-i < 0 || isSelected[c-i]) {
							iCanGo = false;
							break LOOP;
						}
						isSelected[c-i] = true;
					}
					idx = c + 1;
				} else if(preHigh > map[r][c]) {	// 내리막 경사로를 놓아야 하는 경우
					for (int i = 0; i < L; i++) {
						if(c+i >= N || map[r][c+i] != map[r][c]) {
							iCanGo = false;
							break LOOP;
						}
						isSelected[c+i] = true;
					}
					idx = c + L;
				}
				preHigh = map[r][c];
			}//for c end
			if(iCanGo) {
				iCanGoCnt++;
			}
		}//for r end
	} 
}