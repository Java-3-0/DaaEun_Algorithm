import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 13208 kb
// 112 ms
/*
     0 X 0 		1
   0 X 0 0		2
   0 X X 0		?? 왜 얘는 안하지? // 2case보다 더 커질 수 없다
 0 X X 0 0		3
 */
public class 포도주시식_2156_Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] wine = new int[N+1];
		for (int n = 1; n <= N; n++) {
			wine[n] = Integer.parseInt(br.readLine());
		}
//		System.out.println(Arrays.toString(wine));

		int[] maxWine = new int[N+1];
		maxWine[0] = 0;
		maxWine[1] = wine[1];
		if(N == 1) {
			System.out.println(maxWine[1]);
			return;
		}
		maxWine[2] = wine[1] + wine[2];
		if(N == 2) {
			System.out.println(maxWine[2]);
			return;
		}
		maxWine[3] = Math.max(Math.max(wine[1]+wine[2], wine[2]+wine[3]), wine[1]+wine[3]);
		if(N == 3) {
			System.out.println(maxWine[3]);
			return;
		}
		for (int n = 4; n <= N; n++) {
			int case1 = maxWine[n-2] + wine[n];
			int case2 = maxWine[n-3] + wine[n-1] + wine[n];
			int case3 = maxWine[n-4] + wine[n-1] + wine[n];
			maxWine[n] = Math.max(Math.max(case1, case2), case3);
		}
//		System.out.println(Arrays.toString(maxWine));
		System.out.println(Math.max(Math.max(maxWine[N-2], maxWine[N-1]), maxWine[N]));
	}
}
