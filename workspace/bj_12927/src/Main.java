import java.io.BufferedReader;
import java.io.InputStreamReader;

// Bj 12927.배수 스위치
// 11524 kb
// 80 ms
public class Main {
	
	static int[] light;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] lightStr = br.readLine().toCharArray();
		int N = lightStr.length;
		
		light = new int[N];
		for (int i = 0; i < N; i++) {
			if(lightStr[i] == 'Y') light[i] = 1;
			else light[i] = 0;
		}
		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			if(light[i] == 0) continue;
			else {
				answer++;
				for (int j = i; j < N; j += i+1) {
					if(light[j] == 0) light[j] = 1; 
					else if(light[j] == 1) light[j] = 0; 
				}
			}
		}
		System.out.println(answer);
	}
}
