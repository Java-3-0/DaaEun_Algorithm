import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BJ 2578.빙고
// 11572 kb
// 76 ms
public class Main {

	static int bingoCnt;
	// 시계방향
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[][] board = new int[5][5];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] mc = new int[5][5];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				mc[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int curR = -1;
		int curC = -1;
		for (int mcSay : mc[0]) {
			LOOP: for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					if (mcSay == board[r][c]) {
						board[r][c] = 0;
						curR = r;
						curC = c;
						break LOOP;
					}
				} // for c end
			} // for r end
		}
		Bingo(curR, curC);

		for (int i = 1; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				LOOP: for (int r = 0; r < 5; r++) {
					for (int c = 0; c < 5; c++) {
						if (mc[i][j] == board[r][c]) {
//							System.out.println(mc[i][j] + " [" + r + ", " + c + "]");
							board[r][c] = 0;
							Bingo(r, c);
							if (bingoCnt >= 3) {
								System.out.println((i * 5) + (j + 1));
								return;
							}
							break LOOP;
						}
					} // for c end
				} // for r end
			} // for j end
		} // for i end

	}

	public static void Bingo(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			int cnt = 0;
			for (int k = 1; k < 5; k++) {
				nr = r + dr[d] * k;
				nc = c + dc[d] * k;
				if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || board[nr][nc] > 0)
					break;
				cnt++;
			}
			int cnt2 = 5 - cnt;
			for (int k = 1; k < cnt2; k++) {
				nr = r + dr[(d + 4) % 8] * k;
				nc = c + dc[(d + 4) % 8] * k;
				if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || board[nr][nc] > 0)
					break;
				cnt++;
			}
			if (cnt == 4) {
//				System.out.println("빙고 증가!" + r + " " + c + " " + d);
				bingoCnt++;
			}
		}
	}
}
