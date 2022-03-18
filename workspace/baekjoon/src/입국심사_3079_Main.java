import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 21668 kb
// 284 ms
public class 입국심사_3079_Main {
	
	static int N;
	static long M;
	static long answer;
	static int[] stop;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		
		stop = new int[N];
		long maxStop = 0;
		for (int n = 0; n < N; n++) {
			stop[n] = Integer.parseInt(br.readLine());
			maxStop = Math.max(maxStop, stop[n]);
		}
		UpDown(0, maxStop*M);
		System.out.println(answer);
	}
	
	public static void UpDown(long minTime, long maxTime) {
		
		if(minTime == maxTime) {
			answer = minTime;
			return;
		}
		
		long midTime = (maxTime + minTime) / 2;
		long maxCheck = 0;
		for (int n = 0; n < N; n++) {
			maxCheck += midTime / stop[n];
		}
		
		if(maxCheck >= M) UpDown(minTime, midTime);
		else UpDown(midTime+1, maxTime);
	}
	
}