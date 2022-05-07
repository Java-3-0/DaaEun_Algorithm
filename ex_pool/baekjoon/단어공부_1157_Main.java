import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어공부_1157_Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		
		int[] count = new int[26];
		for (int i = 0; i < str.length; i++) {
			char ch = str[i];
			if('a' <= ch && ch <= 'z') count[ch-'a']++;
			else count[ch-'A']++;
		}
		
		int maxIdx = 0;
		int maxCnt = 0;
		int maxIdxCnt = 0;
		for (int i = 0; i < 26; i++) {
			if(maxCnt < count[i]) {
				maxCnt = count[i];
				maxIdx = i;
				maxIdxCnt = 1;
			} else if(maxCnt == count[i]) {
				maxIdxCnt++;
			}
		}
		
		if(maxIdxCnt == 1) System.out.println((char)('A' + maxIdx));
		else System.out.println("?");
	}
}
