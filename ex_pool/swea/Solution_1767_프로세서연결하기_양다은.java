import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swea_1767_프로세서연결하기_Solution {
	
	// 좌 우 상 하
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static int N, M, maxCore, minLen;
	static int[][] board;
	static ArrayList<int[]> core;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			maxCore = 0;
			minLen = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			core = new ArrayList<int[]>();
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					board[r][c] = Integer.parseInt(st.nextToken());
					if(board[r][c] == 1) {
						core.add(new int[]{r, c});
					}//if 1일때 end
				}//for c end
			}//for r end
			M = core.size();
			func1(0, 0, 0);		
			sb.append("#" + tc + " " + minLen + "\n");
		}
		System.out.println(sb.toString());
	}
	
	//완전탐색
	public static void func1(int cur, int toLen, int coreCnt) {

		if(cur == M) {
			if(maxCore < coreCnt) {
				maxCore = coreCnt;
				minLen = toLen;
			} else if(maxCore == coreCnt) {
				minLen = Math.min(minLen, toLen);
			}
			return;
		}
		
		//4방탐색
		for (int d = 0; d < 4; d++) {
			int nr = core.get(cur)[0];
			int nc = core.get(cur)[1];
			int len = func2(nr, nc, d, 0);
			if(len == -1) continue;
			func3(nr, nc, d, len, 2);	//전선 연결하기
			func1(cur+1, toLen+len, coreCnt+1);
			func3(nr, nc, d, len, 0);	//연결한 전선 취소
		}
		func1(cur+1, toLen, coreCnt);
	}
	
	//전선길이 구하기
	public static int func2(int nr, int nc, int d, int len) {
		
		nr += dr[d];
		nc += dc[d];
		
		if(nr<0 || nr>=N || nc<0 || nc>=N) return len;
		if(board[nr][nc] == 1 || board[nr][nc] == 2) return -1;
		
		return func2(nr, nc, d, ++len);
	}
	
	//board판 업데이트
	public static void func3(int nr, int nc, int d, int len, int wire) {
		
		for (int l = 0; l < len; l++) {
			nr += dr[d];
			nc += dc[d];
			board[nr][nc] = wire;
		}
	}	
}