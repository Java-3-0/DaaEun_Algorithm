package bj_2563;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// bj 2563. 색종이
// 11648 kb	
// 76 ms
public class Main {

	static int[][] bigPaper = new int[100][100];
	
	public static void main(String[] args) throws Exception {
		
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int i = x; i < x+10; i++) {
				for (int j = y; j < y+10; j++) {
					bigPaper[i][j] = 1;
				}
			}
		} // for(n)-end
		
		int answer = 0;
		for (int[] rPaper : bigPaper) {
			for(int paper : rPaper) {
				if(paper == 1) answer++;
			}
		}
		System.out.println(answer);
	}
}
