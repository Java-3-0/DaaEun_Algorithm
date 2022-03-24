import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 18584 kb
// 164 ms
public class 사탕박사고창영_2508_Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < TC; tc++) {
			br.readLine();
			st = new StringTokenizer(br.readLine(), " ");
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			char[][] board = new char[R][];
			for (int r = 0; r < R; r++) {
				board[r] = br.readLine().toCharArray();
			}
			
			int candyCnt = 0;
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if(board[r][c] == 'o') {
						// 가로 사탕 체크
						if(c-1>=0 && c+1<C && board[r][c-1] == '>' && board[r][c+1] == '<') {
							candyCnt++;
//							System.out.println("[" + r + "][" + c + "]");
							continue;
						}
						// 세로 사탕 체크
						if(r-1>=0 && r+1<R && board[r-1][c] == 'v' && board[r+1][c] == '^') {
							candyCnt++;
//							System.out.println("[" + r + "][" + c + "]");
						}
					}
				}
			}
			sb.append(candyCnt).append("\n");
		}//for tc end
		System.out.println(sb.toString());
	}
}
