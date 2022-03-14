package bj_7576;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Bj 7576.토마토
// 150468 kb
// 560 ms
public class Main {
	
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	
	static int N, M;
	static int[][] box;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		box = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		findStart();
	}

	public static int checkedBox(int dayCnt) {
		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				if (box[r][c] == 0) {
					return -1;
				}
			}
		}
		return dayCnt;
	}
	
	public static void findStart() {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				if (box[r][c] == 1) {
					queue.offer(new int[]{r, c});
				}
			}
		}
		ripenTomato(-1, queue);
	}
	
	public static void ripenTomato(int dayCnt, Queue<int[]> queue) {
		
		if(queue.isEmpty()) {
			System.out.println(checkedBox(dayCnt));
			return;
		}
		
		Queue<int[]> nextQueue = new LinkedList<int[]>();
		
		while(!queue.isEmpty()) {
			int[] tomato = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = tomato[0] + dr[d];
				int nc = tomato[1] + dc[d];
				
				if(nr < 0 || nr >= M || nc < 0 || nc >= N || box[nr][nc] != 0) continue;
				
				box[nr][nc] = 1;
				nextQueue.offer(new int[] {nr, nc});
			}
		} //while-end
		ripenTomato(++dayCnt, nextQueue);
	}	
}
