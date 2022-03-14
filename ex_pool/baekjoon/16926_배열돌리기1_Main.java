package com.ssafy.bj_16926;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
4 4 2
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
 */
// BJ 16926. 배열 돌리기 1 
// 35920 kb
// 632 ms
public class Main {

	public static void main(String[] args) throws Exception {
		
		// 우, 하, 좌, 상 : 시계방향
		int[] dr = {0, 1, 0, -1}; 
		int[] dc = {1, 0, -1, 0};
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		
		// 입력받기
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int m = 0; m < M; m++) {
				arr[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 알고리즘
		for (int i = 0; i < R; i++) {	// R번 반복
			for (int j = 0; j < Math.min(N, M)/2; j++) {	// 시작좌표 개수 반복
				// 시작좌표 
				int r = j;
				int c = j;
				// temp = 시작좌표 값 저장 
				int temp = arr[j][j];
				// 반시계 회전
				int d = 0;
//				System.out.println("j : " + j + ", d : " + d);
				while(d < 4) {
					if ((r + dr[d]) >= (0+j) && (r + dr[d]) < (N-j) && (c + dc[d]) >= (0+j) && (c + dc[d]) < (M-j)) {
						// 이동시킬 좌표
						int nextR = r + dr[d];
						int nextC = c + dc[d];
//						System.out.println("nextR : " + nextR + ", nextC : " + nextC);
						arr[r][c] = arr[nextR][nextC];
						r = nextR;
						c = nextC;
					} else d++;
				} //while-end
				arr[j+1][j] = temp;				
			} //for(j)-end
		} //for(i)-end
		
		// 출력하기
		for(int[] ar : arr) {
			for(int a : ar) {
				sb.append(a + " ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
}
