import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 38720 kb
// 520 ms
public class 작은수내기_16471_Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num = (N+1)/2;
		
		int[] jooeon = new int[N];
		int[] boss = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			jooeon[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			boss[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(jooeon);
		Arrays.sort(boss);
		
		int idx = 0;	// 주언이 카드 인덱스
		for (int i = 0; i < N; i++) {
			
			if(idx == num) break;
			
			if(jooeon[idx] < boss[i]) {
				idx++;
				continue;
			}
		}// for i end
		
		System.out.println(idx == num ? "YES" : "NO");
	}
}
