import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	static StringBuilder sb = new StringBuilder();
	static int[] dr = { 0, 1, 0, -1 }; // 방향 행 : 우 하 좌 상
	static int[] dc = { 1, 0, -1, 0 }; // 방형 열 : 우 하 좌 상

	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(bf.readLine()); // 달팽이 크기
			int[][] snail = new int[n][n];
			sb.append("#" + tc + "\n");
			recSnailArray(n, snail, 1, 0, 0, 0);
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					sb.append(snail[r][c] + " ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	// recSnailArray() : 달팽이 배열 생성하는 재귀 함수
	// n:크기 , snail:달팽이배열 , go:달팽이 숫자 , des:마지막 달팽이 숫자 , nr:행 , nr:열 , d:방향조절
	private static void recSnailArray(int n, int[][] snail, int go, int nr, int nc, int d) {

		if (go > n*n)	return;

		snail[nr][nc] = go;
//		System.out.println("snail[" + nr + "][" + nc + "] = " + go);
		if (nr+dr[d] < 0 || nr+dr[d] >= n || nc+dc[d] < 0 || nc+dc[d] >= n	// 배열 경계를 넘게 될 경우
			|| snail[nr+dr[d]][nc+dc[d]] != 0) {							// 해당 배열에 이미 값이 들어간 경우
			d = (++d % 4);
		}
		recSnailArray(n, snail, ++go, nr+dr[d], nc+dc[d], d);
	}
}