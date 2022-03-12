import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BJ 14890.경사로
// kb
// ms
// 좌우 카운트(nextCnt, preCnt)로 하면,,, 굉장히 불편해진다. 또한 임저씨도 엎었다. 고로, 나도 엎는다.
public class Main {
	
	static int N, L, iCanGoCnt;
	
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
		System.out.println("map2");
		canGo(map2);
		System.out.println();
		System.out.println(iCanGoCnt);
	}
	public static void canGo(int[][] map) {
		for (int r = 0; r < N; r++) {
			int idx = 1;
			boolean iCanGo = true;
			int current = map[r][0];
			int preCnt = 1;
			LOOP : for (int c = idx; c < N; c++) {
				if(current == map[r][c]) {
					preCnt++;
				}else if(current > map[r][c]) {		// 내리막 경사로를 놓아야하는 경우, preCnt 고려 X
					if(current - map[r][c] != 1) {
						System.out.println("내리막문제1");
						iCanGo = false;
						break;
					}
					// 직전 높이와 1차이인 경우
					current = map[r][c];
					int nexCnt = 1;	// 현상태에서는 무조건 nextCnt = 1 임
					while(nexCnt != L) {
						System.out.println("r : " + r + ", nexCnt : " + nexCnt + ", c : " + c);
						if(++c == N || current != map[r][c]) {
							System.out.println("내리막문제2");
							iCanGo = false;
							break LOOP;	
						}
						nexCnt++;
					}
					idx = c+1;
					System.out.println("r : " + r + ", idx : " + idx);
					if(idx < N && (current - map[r][idx]) > 1) {
						System.out.println("내리막문제3");
						iCanGo = false;
						break LOOP;	
					}
					preCnt = 1;
				}else {	// 오르막 경사로를 놓아야하는 경우, current < map[r][c], nexCnt 고려 X
					if(map[r][c] - current != 1) {
						System.out.println("오르막문제1");
						iCanGo = false;
						break;
					}
					// 직전 높이와 1차이인 경우
					current = map[r][c];
					if(preCnt < L) {
						System.out.println("preCnt : " + preCnt);
						System.out.println("오르막문제2");
						iCanGo = false;
						break LOOP;	
					}
					idx = c;
					preCnt = 0;
				}
			}//for c end(ROOP)
			if(iCanGo) {
				System.out.println("!!!!!!!!r : " + r);
				iCanGoCnt++;
			}
		}//for r end
	} 
}
/*

3 2 2 2 2 3
 */
// 3 2 2 2 2 3