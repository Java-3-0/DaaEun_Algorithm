import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import Main_14502_연구소_양다은.Pos;

public class Main_17135_캐슬디펜스_양다은 {
	
	static int N, M, D;
	static int[][] map;
	static int[] archer = new int[3];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	public static void combi(int start, int cnt) {
		
		if(cnt == 3) {
			copyMap(new int[N+1][M]);
			return;
		}
		
		for (int i = start; i < N; i++) {
			archer[cnt] = i;
			combi(i+1, cnt+1);
		}
	}
	
	public static void game(int[][] tmpMap) {
		
		for (int d = N-1; d <= N-D; d++) {
			
		}
		
	}
	
	public static int[][] copyMap(int[][] tmpMap) {
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				tmpMap[r][c] = map[r][c];
			}
		}
		for (int i = 0; i < 3; i++) {
			tmpMap[N][archer[i]] = 2;
		}

		return tmpMap;
	}
}
