import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Bj 10157. 자리배정
// 56992 kb
// 124 ms
public class Main {
	
	// 하 우 상 좌
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] seat;
 	
	static int C, R, K;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		seat = new int[R][C];
		
		if(K > C*R) {
			System.out.println(0);
			return;
		}
		makeSeatNo(0, 0, 0, 1);
	}
	
	public static boolean makeSeatNo(int c, int r, int d, int seatNo) {
		
		seat[r][c] = seatNo;
//		System.out.println("c : " + c + ", r : " + r + ", seatNo : " + seatNo);
		if(seatNo == K) {
			System.out.println((c+1) + " " + (r+1));
			return true;
		}
		
		while(true) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nc < 0 || nc >= C || nr < 0 || nr >= R || seat[nr][nc] != 0) d = ++d % 4;
			else {
				if(makeSeatNo(nc, nr, d, ++seatNo))	return true;
			}
		}
	}
}
