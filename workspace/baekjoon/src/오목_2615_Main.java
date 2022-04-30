import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11616 kb
// 80 ms
public class 오목_2615_Main {
	
	static int[][] map = new int[19][19];
	static int[] dr = {1, 0, 1, 1}; 
	static int[] dc = {0, 1, 1, -1}; 
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("Test5.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int r=0; r<19; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int c=0; c<19; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean isdraw = true;
		
		LOOP : for (int r = 0; r < 19; r++) {
			for (int c = 0; c < 19; c++) {
				if(map[r][c] != 0 && isCheckedFive(r, c, map[r][c])) {
					isdraw = false;
					break LOOP;
				}
			}
		}
		
		// 무승부인 경우
		if(isdraw) sb.append(0);
		System.out.println(sb.toString());
	}
	
	public static boolean isCheckedFive(int startR, int startC, int color) {
		
		boolean gameEnd = false;
		
		int nr, nc;
		boolean isFive;
		LOOP : for (int d = 0; d < 4; d++) {
			isFive = true;
//			System.out.println(startR + ", " + startC + ", " + color);
			for (int k = 0; k <= 4; k++) {
				nr = startR + dr[d]*k;
				nc = startC + dc[d]*k;
				
				if(!isRange(nr, nc, color)) {
					isFive = false;
					break;
				}
			}
			
			if(isFive) {
				// 6개 같은지 체크
//				System.out.println(startR + ", " + startC + ", " + color);
				boolean isnotSix = false;
				int nr2 = startR + dr[d]*(-1);
				int nc2 = startC + dc[d]*(-1);
				int nr3 = startR + dr[d]*5;
				int nc3 = startC + dc[d]*5;
				if(!isRange(nr2, nc2, color) && !isRange(nr3, nc3, color)) isnotSix = true;
				
				if(isnotSix) {
					//이긴 바둑알 색
					sb.append(color).append("\n");
					//이긴 바둑알 왼쪽 좌표
					if(d == 3) {
						startR = startR + dr[d]*4;
						startC = startC + dc[d]*4;
					}
					sb.append(startR+1).append(" ").append(startC+1).append(" ");
					gameEnd = true;
					break LOOP;
				}
			}
		}
		return gameEnd;
	}
	
	public static boolean isRange(int nr, int nc, int color) {
		
//		// 0 : 범위 밖인 경우
//		if(nr<0 || nc<0 || nr>=19 || nc>=19) return 0;
//		// 1 : 같은 색인 경우
//		if(map[nr][nc] == color) return 1;
//		// 2 : 다른 색인 경우
//		else return 2;
		
		if(nr<0 || nc<0 || nr>=19 || nc>=19 || map[nr][nc] != color) return false;
		return true;
	}
}
