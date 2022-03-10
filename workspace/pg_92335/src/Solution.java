import java.io.BufferedReader;
import java.io.InputStreamReader;

// PG 92335.k진수에서 소수 개수 구하기
// kb
// ms

//	class Solution {
//	    public int solution(int n, int k) {
//	        int answer = -1;
//	        return answer;
//	    }
//	}
// 윤식오빠가 에라토스테네스의 체 쓰라고 해서 했는데 런타임 에러가 났다!!
// 그래서 테스트 1, 11을 통과하지 못했따!!
// 화딱지가 아주 잔뜩난다!
public class Solution {
	
	static int[] primeNum = new int[1000001];
	
	// 에라토스테네스의 체 함수
	public static void primeNumberSieve() {
		// 배열 초기화
		for (int i = 2; i < 1000001; i++) {
			primeNum[i] = i;
		} 
		//지우기
		for (int i = 2; i < 1000001; i++) {
			// 이미 지워진 경우
			if(primeNum[i]==0) continue;
			// 지워지지 않은 경우 - 자기자신 제외한 수부터 배수 지우기
			for (int j = i*2; j < 1000001; j+=i) {
				primeNum[j] = 0;
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		int answer = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		String kNum = Integer.toString(N, k);
		String[] p = kNum.split("0");
		
		primeNumberSieve();
		for (int i = 0; i < p.length; i++) {
			if(p[i].equals("")) continue;
			int decimalP = Integer.parseInt(p[i]);
			// 소수인지 확인하기
			if(primeNum[decimalP] != 0) answer++;
		}
		System.out.println(answer);
	}
}
