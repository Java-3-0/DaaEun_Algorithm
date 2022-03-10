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
public class Solution2 {
	
	public static void main(String[] args) throws Exception{
		int answer = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		String kNum = Integer.toString(n, k);
		String[] p = kNum.split("0");
		
		for (int i = 0; i < p.length; i++) {
			if(p[i].equals("")) continue;
			long decimalP = Long.parseLong(p[i]);
//			System.out.println(decimalP);
			// 소수인지 확인하기
			if(isPrimeNumber(decimalP)) answer++;
		}
		System.out.println(answer);
	}
	
	public static boolean isPrimeNumber(long num) {
		if(num == 1) return false;
		if(num == 2 || num == 3) return true;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) return false;
		}
		return true;
	}
}
