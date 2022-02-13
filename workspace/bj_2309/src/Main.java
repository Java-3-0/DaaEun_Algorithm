import java.io.BufferedReader;
import java.io.InputStreamReader;

// BJ 2309.일곱 난쟁이
// 틀렸습니다.
// 이유 추측 : 재귀문 return을 저기서 실행해도 남은 재귀문이 돌면서 더 가능한 일곱난쟁이를 찾아서 출력하기 때문일 것이다. 
public class Main {

	static int[] dwarfs = new int[9];
	static int[] realDwarfs = new int[7];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			dwarfs[i] = Integer.parseInt(br.readLine());
		}
		findDwarf(0, 0, 0);
	}

	private static void findDwarf(int cnt, int start, int sum) {
		
		if(cnt < 7 && sum >= 100) return;
		
		if(cnt == 7) {
			if(sum == 100) {
				for (int height : realDwarfs) {
					System.out.println(height);
				}
			}
			return;
		}
		
		for (int i = start; i < 9; i++) {
			realDwarfs[cnt] = dwarfs[i];
			findDwarf(cnt+1, i+1, sum + dwarfs[i]);
		}
	}
}
