package bj_2615;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

		static int[][] map = new int[19][19];
		static int winCnt;
		static int[] dr = {0, 1, 1, 1};
		static int[] dc = {1, -1, 0, 1};
		static boolean answer = false;
		
		public static void main(String[] args) throws IOException {
			System.setIn(new FileInputStream("Test5.txt"));
			
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			
			for(int r=0; r<19; r++) {
				StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
				for(int c=0; c<19; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 제대로 입력받았는지 확인
//			for(int r=0; r<19; r++) {
//				for(int c=0; c<19; c++) {
//					System.out.print(map[r][c] + " ");
//				}
//				System.out.println();
//			}
			
			for(int r=0; r<19; r++) {
				for(int c=0; c<19; c++) {
					winCnt = 0;
					if(map[r][c] == 1 || map[r][c] == 2) {
//						System.out.println("1또는 2입니다. r : " + r + " c : " + c);
						if(isGameDone(3, 3, r, c, map[r][c], winCnt)) {
//							System.out.println("결과가 났어요");
							System.out.println(map[r][c]);
							System.out.println((r+1) + " " + (c+1));
							return;
						}
					}
				} // c-for end
			} // r-for end
			
			System.out.println(0);
		}

		
		
		private static boolean isGameDone(int ddr, int ddc, int r, int c, int win, int winCnt) {
			
			//winCnt이 5가 아닌 4인 이유 : 처음 시작할때 하나를 가지고 시작! 4번만 체크하면 된다.
			if(winCnt == 4) {	// 승부가 결정난 경우 
				answer = true;
				if(r+ddr<19 && c+ddc>=0 && c+ddc<19 && map[r+ddr][c+ddc] == win) {	// 그러난 6알 이상 연속될 경우도 체크!
//					System.out.println("6알 연속입니다!");
					answer = false;
				}
				return answer;
			} else if(winCnt == 0) {	// 처음 재귀함수를 시작할 경우
				for(int d=0; d<dr.length; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(nr<19 && nc>=0 && nc<19 && map[nr][nc] == win) {
//						System.out.println("1번째 도는중");
						isGameDone(dr[d], dc[d], nr, nc, win, ++winCnt);
					}
				}
			} else {	// 한가지 방향으로 체크할 경우 
				if(r+ddr<19 && c+ddc>=0 && c+ddc<19 && map[r+ddr][c+ddc] == win) {
//					System.out.println((winCnt+1) + "번째 도는중");
					isGameDone(ddr, ddc, r+ddr, c+ddc, win, ++winCnt);
				}
			}
			
			return answer;
		}	
}
