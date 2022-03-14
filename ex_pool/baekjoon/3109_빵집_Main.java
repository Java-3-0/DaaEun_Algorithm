package com.ssafy.bj_3109;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BJ 3109.빵집
// 52464 kb
// 1508 ms
public class Main {
	
	static int R, C, MAXpipeline;
	static char[][] map;
	static boolean[][] flag;
	 
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		flag = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			char[] str = br.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				map[r][c] = str[c];
			}
		}
		
		countPipeline(0);
		System.out.println(MAXpipeline);
	}
	public static void countPipeline(int cnt) {
		if(cnt == R-MAXpipeline) return;

		int temp = 0;
		for (int i = cnt; i < R; i++) {
			if(buildPipeline(i, 0)) {	// 시작 지점 (r, c), c는 고정
				temp++;
			}
		}
		MAXpipeline = temp > MAXpipeline ? temp : MAXpipeline;
		countPipeline(++cnt);
	}
	
	public static boolean buildPipeline(int r, int c) {
		
		if(c == C-1) {
			return true;
		}
		
		for (int i = -1; i <= 1; i++) {
			int nr = r + i;
			int nc = c + 1;
			if(nr < 0 || nr >= R || map[nr][nc] == 'x' || flag[nr][nc] == true) continue;
			// 빈칸일 경우
			flag[nr][nc] = true;
			if (buildPipeline(nr, nc)) return true;
		}
		return false;
	}
}
