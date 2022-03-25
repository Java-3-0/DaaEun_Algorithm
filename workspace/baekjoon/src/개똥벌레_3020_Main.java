import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 35012 kb
// 344 ms
public class 개똥벌레_3020_Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int midN = N/2;
		
		int[] caveCnt = new int[H+1];
		int[] caveDown = new int[midN];
		int[] caveUp = new int[midN];
		int a = 0;
		for (int n = 0; n < midN; n++) {
			caveDown[a] = Integer.parseInt(br.readLine());
			caveUp[a] = Integer.parseInt(br.readLine());
			a++;
		}
		
		Arrays.sort(caveDown);  // [1, 3, 5]
		Arrays.sort(caveUp);	// [1, 3, 5]
		
		int idx = 0;
		for (int i = 1; i <= H; i++) {
			if(caveDown[idx] > i) {
				caveCnt[i] = midN - idx;
			} else if(caveDown[idx] == i) {
				caveCnt[i] = midN - idx;
				while(idx < midN && caveDown[idx] == i) idx++;
			}
			if(idx == midN) break;
		}
		// [0, 3, 2, 2, 1, 1, 0, 0]
		idx = 0;
		for (int i = 1; i <= H; i++) {
			if(caveUp[idx] > i) {
				caveCnt[H-i+1] += midN - idx;
			} else if(caveUp[idx] == i) {
				caveCnt[H-i+1] += midN - idx;
				while(idx < midN && caveUp[idx] == i) idx++;
			}
			if(idx == midN) break;
		}
		// [0, 3, 2, 3, 2, 3, 2, 3]
//		System.out.println(Arrays.toString(caveCnt));
		
		int min = Integer.MAX_VALUE;
		int minCnt = 0;
		for (int i = 1; i <= H; i++) {
			if(min > caveCnt[i]) {
				min = caveCnt[i];
				minCnt = 1;
			} else if (min == caveCnt[i]) {
				minCnt ++;
			}
		}
		System.out.println(min + " " + minCnt);
	}
}
