import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 32616 kb
// 280 ms
public class 용액_2467_Main {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력받기
		int N = Integer.parseInt(br.readLine());
		long[] liquid = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			liquid[i] = Long.parseLong(st.nextToken());
		}
		
		int left = 0;
		int right = N-1;
		long leftNum = 0, rightNum = 0;
		long min = 2000000000;
		while(left < right) {
			long mix = Math.abs(liquid[left] + liquid[right]);
			
			if(min >= mix) {
				min = mix;
				leftNum = liquid[left];
				rightNum = liquid[right];
			}
			
			if(min == 0) break;
			
			if(Math.abs(liquid[left]) > Math.abs(liquid[right])) left++;
			else right--;
		}
		
		System.out.println(leftNum + " " + rightNum);
	}
}
