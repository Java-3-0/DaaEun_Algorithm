import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 41604 kb
// 252 ms 
public class 연구소3_17142_Main {
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	
	static int N, M, virusCnt, zeroCnt, answer = Integer.MAX_VALUE;
	static int[][] lab;
	static ArrayList<Pos> virus = new ArrayList<Pos>();
	static int[] numbers;
	
	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lab = new int[N][N];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < N; c++) {
				int tmp = Integer.parseInt(st.nextToken());
				switch (tmp) {
				case 2:	
					lab[r][c] = -1;	// 바이러스 위치
					virus.add(new Pos(r, c));
					virusCnt++;
					break;
				case 1:	
					lab[r][c] = -2;	// 벽 위치
					break;
				case 0:	
					lab[r][c] = -3;	// 빈칸 위치
					zeroCnt++;
					break;
				default:
					break;
				}
			}
		}
		
		if(zeroCnt == 0) {
			System.out.println(0);
			return;
		}
		
		numbers = new int[virusCnt];
		combination(0, 0);
		
		System.out.println(answer != Integer.MAX_VALUE ? answer : -1);
	}
	
	public static void combination(int start, int cnt) {
		
		if(cnt == M) {
			bfs(numbers, zeroCnt);
			return;
		}
		
		for (int i = start; i < virusCnt; i++) {
			numbers[cnt] = i;
			combination(i+1, cnt+1);
		}
	}
	
	public static void bfs(int[] actVirus, int zeroCnt) {
		int[][] tmpLab = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				tmpLab[r][c] = lab[r][c];
			}
		}
		Queue<Pos> queue = new LinkedList<Pos>();
		for (int i = 0; i < M; i++) {
//			System.out.print("[" + actVirus[i] + "]");
			queue.offer(virus.get(actVirus[i]));
		}
		int time = -1;
		while(!queue.isEmpty()) {
			time++;
			int curVirusCnt = queue.size();
			for (int i = 0; i < curVirusCnt; i++) {
				Pos curVirus = queue.poll();
				int curR = curVirus.r;
				int curC = curVirus.c;
				tmpLab[curR][curC] = time;
				
				for (int j = 0; j < 4; j++) {
					int nr = curR + dr[j];
					int nc = curC + dc[j];
					
					if(nr<0 || nr>=N || nc<0 || nc>=N || tmpLab[nr][nc]==-2 || tmpLab[nr][nc]>=0) continue;
					
					if(tmpLab[nr][nc] == -3) zeroCnt--;	// 빈칸인 경우
					
					tmpLab[nr][nc] = time+1;
					queue.offer(new Pos(nr, nc));

				} //for 4방탐색 end
			} //for curVirus end
			if(zeroCnt == 0) {
				time = time+1;
				break;
			}
		} //while queue end
		
		if(zeroCnt == 0) {
			answer = Math.min(answer, time);
		}
	}	
}
