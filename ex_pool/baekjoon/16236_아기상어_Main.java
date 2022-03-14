package bj_16236;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BJ 16236.아기상어
public class Main {
	// 상 좌 하 우
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static int N;
	static int sharkR;
	static int sharkC;
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
//				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
	}
}
