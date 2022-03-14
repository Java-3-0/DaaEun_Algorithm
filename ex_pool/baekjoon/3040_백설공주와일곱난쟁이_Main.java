package bj_3040;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BJ 3040.백설 공주와 일곱 난쟁이
// 11460 kb
// 76 ms
public class Main {

	static int[] dwarfs = new int[9];
	static int heightSum;
	
	public static void main(String[] args) throws Exception {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			dwarfs[i] = Integer.parseInt(br.readLine());
			heightSum += dwarfs[i];
		}
		
		LOOP: for (int i = 0; i < 8; i++) {
			for (int j = i+1; j < 9; j++) {
				if(heightSum -(dwarfs[i] + dwarfs[j]) == 100) {
					for (int k = 0; k < 9; k++) {
						if(k == i || k == j) continue;
						sb.append(dwarfs[k] + "\n");
					}
					break LOOP;
				}
			} // for(j)-end
		} // for(i)-end
		System.out.println(sb.toString());
	}
}
