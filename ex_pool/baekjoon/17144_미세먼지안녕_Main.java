package bj_17144;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BJ 17144.미세먼지 안녕!
// 295164 kb
// 568 ms
public class Main {
	
	// 시계방향 : 상, 우, 하, 좌
	static int[] dc = {0, 1, 0, -1};
	static int[] dr = {-1, 0, 1, 0};
	
	static int R, C, T, airclnCCW, airclnCW, answer;
	static int[][] room;
	static Queue<int[]> queue = new LinkedList<int[]>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		room = new int[R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < C; c++) {
				room[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		//공기청정기 위치
		for (int r = 0; r < R-1; r++) {
			if(room[r][0] == -1) {
				airclnCCW = r;
				airclnCW = r+1;
				break;
			}
		}
		powerOn(0);
		System.out.println(answer);
	}
	
	public static void powerOn(int t) {
		
		if(t == T) {
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if(room[r][c] > 0) {
						answer += room[r][c];
					}
				}
			}
			return;
		}
		
		// 1. 미세먼지가 확산된다.(동시에!)
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(room[r][c] > 0) {	// 미세먼지가 존재하는 경우
					int spreadCnt = 0;
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						
						if(nr < 0 || nr >= R || nc < 0 || nc >= C || room[nr][nc] == -1) continue;
//						room[nr][nc] += room[r][c]/5;
						queue.offer(new int[]{nr, nc, room[r][c]/5});
						spreadCnt++;
					}
					room[r][c] -= room[r][c]/5 * spreadCnt;
				}
			}
		}
		while(!queue.isEmpty()) {
			int[] spreadDust = queue.poll();
			room[spreadDust[0]][spreadDust[1]] += spreadDust[2];
		}
		// 2. 공기청정기가 작동한다.
		// 공기청정기 반시계방향 -> 시계방향 : 상, 우, 하, 좌
		airCleaner(new int[]{-1, 0, 1, 0}, airclnCCW, 0, airclnCW);
		// 공기청정기 시계방향 -> 반시계방향 : 하, 우, 상, 좌
		airCleaner(new int[]{1, 0, -1, 0}, airclnCW, airclnCW, R);

		powerOn(++t);
	}
	
	public static void airCleaner(int[] ddr,int r, int startR, int endR) {
		int c = 0;
		int d = 0;
		while(d < 4) {
			int nr = r + ddr[d];
			int nc = c + dc[d];
			
			if(nr < startR || nr >= endR || nc < 0 || nc >= C) {
				d++;
				continue;
			}
			if(room[r][c] != -1) {
				if(room[nr][nc] == -1) break;

				room[r][c] = room[nr][nc];
			}
			room[nr][nc] = 0;
			r = nr;
			c = nc;
		}
	}	
}
