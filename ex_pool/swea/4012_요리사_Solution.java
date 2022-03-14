import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int TC, num, N;
	static int[] combi, Asynergy, Bsynergy;
	static int[][] ingredients;
	
	public static void main(String[] args) throws Exception {
		
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			num = Integer.parseInt(br.readLine());
			int delicious = Integer.MAX_VALUE;
			ingredients = new int[num][num];
			for (int i = 0; i < num; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < num; j++) {
					ingredients[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			N = num-1;
			combi = new int[N];
			Asynergy = new int[num>>1];	//N 포함
			Asynergy[0] = N;
			Bsynergy = new int[num>>1];	//N 미포함
			for (int i = 1; i <= (N>>1); i++) {
				combi[N-i] = 1;
			}
			do {
				int temp = getdelicious();
				delicious = temp < delicious ? temp : delicious;
			} while(np(combi));
			sb.append("#" + tc + " " + delicious + "\n");			
		} //for(tc)-end
		System.out.println(sb.toString());
	}
	
	public static int getdelicious() {
		int Acnt = 1;
		int Bcnt = 0;
		for (int i = 0; i < N; i++) {
			if(combi[i] == 1) {
				Asynergy[Acnt] = i;
				Acnt++;
			} else {
				Bsynergy[Bcnt] = i;
				Bcnt++;
			}
		}
		int ASum  = 0;
		int BSum  = 0;
		for(int i : Asynergy) {
			for(int j : Asynergy) {
				if(i == j) continue;
				ASum += ingredients[i][j];
			}
		}
		for(int i : Bsynergy) {
			for(int j : Bsynergy) {
				if(i == j) continue;
				BSum += ingredients[i][j];
			}
		}
		return Math.abs(ASum - BSum);
	}
	
	public static boolean np(int[] combi) {
		int i = N - 1;
		while(i > 0 && combi[i-1] >= combi[i]) --i;
		
		if(i == 0) return false;
		
		int j = N - 1;
		while(combi[i-1] >= combi[j]) --j;
		
		swap(combi, i-1, j);
		
		int k = N - 1;
		while(i < k) {
			swap(combi, i++, k--);
		}
		return true;
	}
	
	public static void swap(int[] combi, int i, int j) {
		int temp = combi[i];
		combi[i] = combi[j];
		combi[j] = temp;
	}
}