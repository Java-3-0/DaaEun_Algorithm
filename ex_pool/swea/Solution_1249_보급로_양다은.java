import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

// 22456 kb
// 138 ms
public class Solution_1249_보급로_양다은 {

	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	
	static class Fix implements Comparable<Fix>{
		int r, c, dis;

		public Fix(int r, int c, int dis) {
			super();
			this.r = r;
			this.c = c;
			this.dis = dis;
		}

		@Override
		public int compareTo(Fix o) {
			return this.dis - o.dis;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N][N];
			for (int r = 0; r < N; r++) {
				char[] str = br.readLine().toCharArray();
				for (int c = 0; c < N; c++) {
					map[r][c] = str[c] - '0';
				}
			}

			PriorityQueue<Fix> pqueue = new PriorityQueue<Fix>();
			boolean[][] isVisited = new boolean[N][N];
			int[][] distance = new int[N][N];
			for (int r = 0; r < N; r++) {
				Arrays.fill(distance[r], Integer.MAX_VALUE);
			}
			
			distance[0][0] = 0;
			pqueue.offer(new Fix(0, 0, 0));
			
			while(!pqueue.isEmpty()) {
				Fix cur = pqueue.poll();
				if(isVisited[cur.r][cur.c]) continue;
				isVisited[cur.r][cur.c] = true;
				
				for (int d = 0; d < 4; d++) {
					int nr = cur.r + dr[d];
					int nc = cur.c + dc[d];
					
					if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
					
					if(!isVisited[nr][nc] && distance[nr][nc] > cur.dis + map[nr][nc]) {
						distance[nr][nc] = cur.dis + map[nr][nc];
						pqueue.offer(new Fix(nr, nc, distance[nr][nc]));
					}
				}
			}//while end
			sb.append("#").append(tc).append(" ").append(distance[N-1][N-1]).append("\n");
		}// for tc end
		System.out.println(sb.toString());
	}
}
