import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Bj 2116.주사위 쌓기
// 19712 kb
// 204 ms
public class Main {
	
	static int N, answer;
	static int[][] dice;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dice = new int[N][6];
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		decideFirstDice(0);
		System.out.println(answer);
	}
	
	public static void decideFirstDice(int idx) {
		
		if(idx == 6) return;
		
		int sum = 0;
		int bottom = idx;
		int top = topIndex(bottom);
		for (int i = 0; i < N; i++) {
			int temp = 0;
			for (int j = 0; j < 6; j++) {
				if(bottom == j || top == j) continue;
				temp = Math.max(temp, dice[i][j]);
			}
			sum += temp;
			if(i+1 == N) break;
			for (int j = 0; j < 6; j++) {
				if(dice[i][top] == dice[i+1][j]) {
					bottom = j;
					top = topIndex(bottom);
					break;
				}
			}
		}
		answer = Math.max(answer, sum);
		decideFirstDice(++idx);
	}
	
	public static int topIndex(int bottom) {
		int top = -1;
		switch (bottom) {
		case 0: case 5:
			top = 5 - bottom;
			break;
		case 1: case 3:
			top = 4 - bottom;
			break;
		case 2: case 4:
			top = 6 - bottom;
			break;
		}
		return top;
	}	
}
