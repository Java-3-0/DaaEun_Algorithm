import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	// 전차방향 데이터 
	static int[] dr = {-1, 1, 0, 0};	// 상, 하, 좌, 우
	static int[] dc = {0, 0, -1, 1};	// 상, 하, 좌, 우
	
	public static void main(String[] args) throws Exception {
		StringBuffer sb = new StringBuffer();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(bf.readLine());	// 테스트 케이스의 수
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());	// H
			int W = Integer.parseInt(st.nextToken());	// W
			char[][] map = new char[H][W];	// 게임 맵	
			int nr = 0;	// 전차 위치 R
			int nc = 0;	// 전차 위치 C
			int d = -1;
			for (int h = 0; h < H; h++) {
				String line = bf.readLine();
				for (int w = 0; w < W; w++) {
					map[h][w] = line.charAt(w);
					// 전차 위치와 방향
					switch (map[h][w]) {
					case '^': nr = h; nc = w; d = 0; break;
					case 'v': nr = h; nc = w; d = 1; break;
					case '<': nr = h; nc = w; d = 2; break;
					case '>': nr = h; nc = w; d = 3; break;
					} // switch(map[h][w])-end
				} // for(w)-end
			} // for(h)-end

			int N =Integer.parseInt(bf.readLine());			// 사용자가 넣을 입력의 개수
			char[] action = bf.readLine().toCharArray();	// 입력동작
			
			sb.append("#" + tc + " ");
			playGame(H, W, map, nr, nc, d, N, N, action);
			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					sb.append(map[r][c]);
				}
				sb.append("\n");
			}
		} // for(tc)-end
		System.out.println(sb.toString());
	}

	private static void playGame(int H, int W, char[][] map, int nr, int nc, int d, int n, int N, char[] action) {
		if(n == 0) { 
			switch (d) {
			case 0: map[nr][nc] = '^'; return;
			case 1: map[nr][nc] = 'v'; return;
			case 2: map[nr][nc] = '<'; return;
			case 3: map[nr][nc] = '>'; return;
			}
		}
		if(action[N-n] =='S') {
			shotShell(H, W, map, nr, nc, d);
		} else {
			switch (action[N-n]) {
			case 'U': d = 0; break;
			case 'D': d = 1; break;
			case 'L': d = 2; break;
			case 'R': d = 3; break;
			}
			if (nr+dr[d] >= 0 && nr+dr[d] < H && nc+dc[d] >= 0 && nc+dc[d] < W && map[nr+dr[d]][nc+dc[d]] == '.') {
				map[nr][nc] = '.';
				nr = nr+dr[d];
				nc = nc+dc[d];
			}
		}
		playGame(H, W, map, nr, nc, d, n - 1, N, action);
	}
	private static void shotShell(int H, int W, char[][] map, int nr, int nc, int d) {
		if (nr+dr[d] < 0 || nr+dr[d] >= H || nc+dc[d] < 0 || nc+dc[d] >= W || map[nr+dr[d]][nc+dc[d]] == '#') {
			return;
		} else if (map[nr+dr[d]][nc+dc[d]] == '*') {
			map[nr+dr[d]][nc+dc[d]] = '.';
			return;
		}
		shotShell(H, W, map, nr+dr[d], nc+dc[d], d);
	}
}