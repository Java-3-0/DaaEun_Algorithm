import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 수행시간 : 92ms
// 메모리 사용량 : 11712kb
public class Main {

	static int[][] board;

	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 보드판 입력받기
		board = new int[n][m];
		for (int r = 0; r < n; r++) {
			String in = bf.readLine();
			for (int c = 0; c < m; c++) {
				if (in.charAt(c) == 'B')
					board[r][c] = 0; // B(블랙)인 경우, 0
				else
					board[r][c] = 1; // W(화이트)인 경우, 1
			}
		}
		System.out.println(Arrays.deepToString(board));
		
		// 보드판에서 다시 색칠해야하는 칸의 수 계산
		// 이때, 맨 왼쪽 위 칸이 B(블랙)즉, 0인 경우로 우선 계산
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (((r % 2 == 0 && c % 2 == 0) || (r % 2 != 0 && c % 2 != 0)) && board[r][c] != 0)
					// [홀][홀] 또는 [짝][짝]인 배열위치에 값이 0이 아닌 경우
					board[r][c] = 2; // 재색칠한 경우, 2
				else if (((r % 2 != 0 && c % 2 == 0) || (r % 2 == 0 && c % 2 != 0)) && board[r][c] != 1)
					// [홀][짝] 또는 [짝][홀]인 배열위치에 값이 1이 아닌 경우
					board[r][c] = 2;
			}
		}
		System.out.println(Arrays.deepToString(board));
		
		// 최소로 다시 칠하는 칸의 수 계산
		int minCnt = 32; // (8 * 8) / 2
		for (int startR = 0; startR < n - 7; startR++) { // 마지막 startR = n - 8
			for (int startC = 0; startC < m - 7; startC++) { // 마지막 startC = m - 8
//				System.out.println("["+startR+"]["+startC+"]");
				// bestChess() : 8X8 크기의 체스판으로 잘라서 각 재색칠 칸의 갯수 계산
				minCnt = Math.min(bestChess(startR, startC), minCnt);
//				System.out.println("minCnt : " + minCnt);
			}
		}
		System.out.println(minCnt);
	}

	// bestChess() : 8X8 크기의 체스판으로 잘라서 각 재색칠 칸의 갯수 계산
	private static int bestChess(int startR, int startC) {
		int blackFirst = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(board[startR+i][startC+j] == 2) blackFirst++;
			}
		}
		// 맨 왼쪽 위 칸이 W(화이트)즉, 1인 경우 고려
		// whiteFirst = 64 - blackFirst;
		return Math.min(blackFirst, 64 - blackFirst);
	}
}
