package com.ssafy.bj_1987;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Bj 1987.알파벳
// 12368 kb
// 1048 ms
public class Main2 {
	
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	static int R, C, answer;
	static int[][] board;
	static boolean[] isUsed = new boolean[26];	// 26가지 알파벳 사용 유무
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new int[R][C];
		
		for (int i = 0; i <R; i++) {
			char[] str = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				board[i][j] = str[j] -'A';
			}
		}
		dfs(0, 0, 0);
		System.out.println(answer);
	}
	
	public static void dfs(int r, int c, int cnt) {
		
//		System.out.println("[" + r + "][" + c + "]");
		if(isUsed[board[r][c]]) {
			answer = answer < cnt ? cnt : answer;
			return;
		}
		
		isUsed[board[r][c]] = true;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
			dfs(nr, nc, cnt+1);
		}
		isUsed[board[r][c]] = false;
	}	
}
