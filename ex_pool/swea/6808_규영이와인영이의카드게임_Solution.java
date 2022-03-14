import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int TC, winCnt;
	static boolean[] card;
	static int[] gyuyoungCard = new int[9];
	static int[] inyoungCard = new int[9];
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			winCnt = 0;
			card = new boolean[19];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 9; i++) {
				gyuyoungCard[i] = Integer.parseInt(st.nextToken());
				card[gyuyoungCard[i]] = true;
			}
			int idx = 0;
			for (int i = 1; i < 19; i++) {
				if(!card[i]) inyoungCard[idx++] = i;
			}
			Arrays.sort(inyoungCard);
			do {
				playGame(0, 0);
			}while(np());
			sb.append("#" + tc + " " + winCnt + " " + (362880-winCnt) + "\n");
		}
		System.out.println(sb.toString());
	}

	private static boolean np() {
		
		int i = 8;
		while(i > 0 && inyoungCard[i-1] >= inyoungCard[i]) --i;
		
		if(i == 0) return false;
		int j = 8;
		while(inyoungCard[i-1] >= inyoungCard[j]) --j;
		
		swap(i-1, j);
		
		int k = 8;
		while(i < k) {
			swap(i++, k--);
		}
		return true;
	}

	private static void swap(int i, int j) {
		int temp = inyoungCard[i];
		inyoungCard[i] = inyoungCard[j];
		inyoungCard[j] = temp;
	}
	
	private static void playGame(int round, int gyuyoungSum) {
		
		if(round == 9) {
			if(gyuyoungSum > 171-gyuyoungSum) winCnt++;
			return;
		}
		
		if(gyuyoungCard[round] > inyoungCard[round]) {
			gyuyoungSum += gyuyoungCard[round] + inyoungCard[round];
		}
		playGame(++round, gyuyoungSum);
	}
}