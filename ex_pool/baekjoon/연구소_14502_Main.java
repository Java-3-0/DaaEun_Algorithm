import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 126996 kb
// 324 ms
public class Main_14502_연구소_양다은 {
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	
	static class Pos {
		int r, c;
		
		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M, emptySize, maxSafe;
	static int[][] lab;
	static ArrayList<Pos> empty = new ArrayList<Pos>();
	static ArrayList<Pos> virus = new ArrayList<Pos>();
	static Pos[] tmpWall = new Pos[3];
	static Queue<Pos> queue = new LinkedList<Pos>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lab = new int[N][M];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int m = 0; m < M; m++) {
				lab[n][m] = Integer.parseInt(st.nextToken());
				if(lab[n][m] == 0) empty.add(new Pos(n, m));
				else if(lab[n][m] == 2) virus.add(new Pos(n, m));
			}
		}
		emptySize = empty.size();
		combi(0, 0);
		System.out.println(maxSafe);
		
	}
	
	public static void combi(int start, int cnt) {
		
		if(cnt == 3) {
			int tmpEmptySize = bfs(copyLab(new int[N][M]), emptySize - 3);
//			if(maxSafe < tmpEmptySize) {
//				for (int i = 0; i < 3; i++) {
//					System.out.print("[" + tmpWall[i].r + "][" + tmpWall[i].c + "] ");
//				}
//				System.out.println(tmpEmptySize);
//				maxSafe = tmpEmptySize;
//			}
			maxSafe = Math.max(maxSafe, tmpEmptySize);
			return;
		}
		
		for (int i = start; i < emptySize; i++) {
			tmpWall[cnt] = empty.get(i);
			combi(i+1, cnt+1);
		}
	}
	
	public static int bfs(int[][] tmpLab, int tmpEmptySize) {
		for(Pos pos : virus) {
			queue.offer(pos);
		}
		
		while(!queue.isEmpty()) {
			Pos cur = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(nr<0 || nc<0 || nr>=N || nc>=M || tmpLab[nr][nc] != 0) continue;
				
				tmpLab[nr][nc] = 2;
				tmpEmptySize--;
				queue.offer(new Pos(nr, nc));
			}
			if(tmpEmptySize < maxSafe) {
				queue.clear();
				break;
			}
		}
		return tmpEmptySize;
	}
	
	public static int[][] copyLab(int[][] tmpLab) {
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				tmpLab[r][c] = lab[r][c];
			}
		}
		for(Pos pos : tmpWall) {
			tmpLab[pos.r][pos.c] = 1;
		}
		return tmpLab;
	}
}
