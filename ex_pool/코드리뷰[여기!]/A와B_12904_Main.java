import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 12504 kb
// 76 ms
public class A와B_12904_Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();
		
		int SL = S.length(); 
		int TL = T.length(); 
		// T를 S만큼 자르기
		int pos = TL - 1;
		while(SL < TL) {
//			System.out.println(T);
//			System.out.println(T.charAt(pos));
			if(pos != 0) {
				//문자열의 뒤에 A를 추가한다.
				if(T.charAt(pos) == 'A') {
					T = T.substring(0, pos);
					pos = T.length() - 1;
				} else {	//문자열을 뒤집고 뒤에 B를 추가한다.
					T = T.substring(0, pos);
					pos = 0;
				}
			}
			else {
				//문자열의 뒤에 A를 추가한다.
				if(T.charAt(pos) == 'A') {
					T = T.substring(1);
//					pos = 0;
				} else {	//문자열을 뒤집고 뒤에 B를 추가한다.
					T = T.substring(1);
					pos = T.length() - 1;
				}
			}
			TL = T.length();
		}
		
		//S를 T로 바꿀 수 있으면 1을 없으면 0을 출력한다.
		if(pos == 0) {
			// 문자열 reverse
			StringBuffer sb = new StringBuffer(T);
			T = sb.reverse().toString();
		}
		if(S.equals(T))System.out.println(1);
		else System.out.println(0);
	}
}
