import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// BJ 4485.녹색 옷 입은 애가 젤다지?
// 17692 kb
// 184 ms
public class Main {
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static int N;
	
	static class Pos implements Comparable<Pos>{
		int r;
		int c;
		int weight;
		
		public Pos(int r, int c, int weight) {
			super();
			this.r = r;
			this.c = c;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Pos o) {
			return this.weight - o.weight;
		}
	}
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = 1;
		while((N = Integer.parseInt(br.readLine())) != 0){
			int[][] cave = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(cave[i]));
//			}
			
			//다익스트라
			int[][] minRupee = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(minRupee[i], Integer.MAX_VALUE);
			}
			int startR = 0;
			int startC = 0;
			minRupee[startR][startC] = cave[startR][startC];
			PriorityQueue<Pos> pQueue = new PriorityQueue<Pos>();
			pQueue.add(new Pos(startR, startC, minRupee[startR][startC]));
			
			while(!pQueue.isEmpty()) {
				Pos current = pQueue.poll();
				int curR = current.r;
				int curC = current.c;
				int curW = current.weight;
//				System.out.println("["+curR+"]["+curC+"] : "+curW);
				for (int i = 0; i < 4; i++) {
					int nr = curR + dr[i];
					int nc = curC + dc[i];
					
					if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
					
					if(minRupee[nr][nc] > curW + cave[nr][nc]) {
						minRupee[nr][nc] = curW + cave[nr][nc];
						pQueue.add(new Pos(nr, nc, minRupee[nr][nc]));
					}
				}
			}
			
			sb.append("Problem " + tc++ + ": " + minRupee[N-1][N-1] + "\n");
		}
		System.out.println(sb.toString());
	}
}
