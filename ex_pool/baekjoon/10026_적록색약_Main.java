package bj_10026;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// BJ 10026.적록색약
// 17792 kb
// 288 ms
public class Main {
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static int N, healthyCnt, sickCnt;
	static char[][] draw;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		draw = new char[N][N];
		for (int i = 0; i < N; i++) {
			char[] str = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				draw[i][j] = str[j];
			}
		}
		
		//적록색약이 아닌 사람 관점
		healthyEyes(new boolean[N][N], 0, 0);
		//적록색약인 사람 관점
		sickEyes(new boolean[N][N], 0, 0);
		System.out.println(healthyCnt + " " + sickCnt);
		
	}
	
	public static void healthyEyes(boolean[][] isVisited, int r, int c) {
		healthyCnt ++;
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.offer(new int[] {r, c});
		isVisited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = temp[0] + dr[d];
				int nc = temp[1] + dc[d];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || 
						isVisited[nr][nc] || draw[nr][nc] != draw[temp[0]][temp[1]])
					continue;
				
				queue.offer(new int[] {nr, nc});
				isVisited[nr][nc] = true;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!isVisited[i][j]) healthyEyes(isVisited, i, j);
			}
		}
		return;
	}
	
	public static void sickEyes(boolean[][] isVisited, int r, int c) {
		sickCnt++;
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.offer(new int[] {r, c});
		isVisited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = temp[0] + dr[d];
				int nc = temp[1] + dc[d];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || isVisited[nr][nc])
					continue;
				if(draw[temp[0]][temp[1]] == 'B' && draw[nr][nc] != 'B')	
					continue;
				if(draw[temp[0]][temp[1]] != 'B' && draw[nr][nc] == 'B')	
					continue;
				
				queue.offer(new int[] {nr, nc});
				isVisited[nr][nc] = true;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!isVisited[i][j]) sickEyes(isVisited, i, j);
			}
		}
		return;
	}
}
