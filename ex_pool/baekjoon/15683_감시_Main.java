package com.ssafy.bj_15683;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BJ 15683. 감시
// 15032 kb
// 220 ms
public class Main {
	// 상  좌  하  우
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	
//	static int[][] cctv1idx = {{0}, {1}, {2}, {3}};
//	static int[][] cctv2idx = {{0,2}, {1,3}};
//	static int[][] cctv3idx = {{0,1}, {1,2}, {2,3}, {3,0}};
//	static int[][] cctv4idx = {{0,1,2}, {1,2,3}, {2,3,0}, {3,0,1}};
//	static int[][] cctv5idx = {{0,1,2,3}};
	static int[][][] cctvIdx = {{{0}, {1}, {2}, {3}},
								{{0,2}, {1,3}},
								{{0,1}, {1,2}, {2,3}, {3,0}},
								{{0,1,2}, {1,2,3}, {2,3,0}, {3,0,1}},
								{{0,1,2,3}}
								};
	
	static int R, C,cctvCnt;
	static int  MINblind = Integer.MAX_VALUE;
	static int[][] office, cctvInfo = new int[8][3];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		office = new int[R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < C; c++) {
				office[r][c] = Integer.parseInt(st.nextToken());
				
				// cctv 좌표 (n, m)과 cctv의 종류 저장
				if (office[r][c] == 0 || office[r][c] == 6) continue;
				cctvInfo[cctvCnt++] = new int[]{r, c, office[r][c]};
			}
		}
		monitorCCTV(0);
		System.out.println(MINblind);
	}
	
	public static void monitorCCTV(int cnt) {
		
		if(cnt == cctvCnt) {
//			for (int i = 0; i < R; i++) {
//				System.out.println(Arrays.toString(office[i]));
//			}
//			System.out.println();
			int temp = 0;	// 사각지대 
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if(office[r][c] == 0) temp++;
				}
			}
			MINblind = Math.min(MINblind, temp);	// 최소 사각지대 
			return;
		}
		
		int[][] monitor = cctvIdx[cctvInfo[cnt][2]-1];
		
		for (int i = 0; i < monitor.length; i++) {
			// 감시 영역 칠하기
			for (int j = 0; j < monitor[0].length; j++) {
				for (int k = 1; k < 8; k++) {
					int nr = cctvInfo[cnt][0] + dr[monitor[i][j]] * k;
					int nc = cctvInfo[cnt][1] + dc[monitor[i][j]] * k;
					
					if(nr < 0 || nr >= R || nc < 0 || nc >= C || office[nr][nc] == 6) break;
					if(1 <= office[nr][nc] && office[nr][nc] <= 5) continue;
					// 0 일 경우, 또는 7일 경우
					office[nr][nc] += 7;	// 7(#) : 감시할 수 있는 영역
				}
			}
			monitorCCTV(cnt+1);
			// 감시 영역 지우기
			for (int j = 0; j < monitor[0].length; j++) {
				for (int k = 1; k < 8; k++) {
					int nr = cctvInfo[cnt][0] + dr[monitor[i][j]] * k;
					int nc = cctvInfo[cnt][1] + dc[monitor[i][j]] * k;
					
					if(nr < 0 || nr >= R || nc < 0 || nc >= C || office[nr][nc] == 6) break;
					if(1 <= office[nr][nc] && office[nr][nc] <= 5) continue;
					// 0 일 경우, 또는 7일 경우
					office[nr][nc] -= 7;	// 7(#) : 감시할 수 있는 영역
				}
			}
		} // for(i)-end
	}
}
