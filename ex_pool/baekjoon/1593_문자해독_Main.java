import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BJ 1593.문자 해독
// 139428 kb
// 1112 ms
public class Main {
	
	static int wordLength, strLength, rightWordCnt;
	static char[] word, str;
	
	/**
	 * wordLower : word에서 소문자 개수
	 * wordUpper : word에서 대문자 개수
	 */
	static int[] wordLower = new int[26], wordUpper = new int[26];
	/**
	 * isCheckedLower : str를 체크하는 과정에서  0 : 소문자 개수, 1: 첫 문자 등장 idx
	 * isCheckedUpper : str를 체크하는 과정에서  0 : 대문자 개수, 1: 첫 문자 등장 idx
	 */
	static int[][] isCheckedLower = new int[26][2], isCheckedUpper = new int[26][2];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		wordLength = Integer.parseInt(st.nextToken());
		strLength = Integer.parseInt(st.nextToken());
		word = br.readLine().toCharArray();
		str = br.readLine().toCharArray();
		
		// word를 wordLower, wordUpper데이터로 전환
		for (int i = 0; i < wordLength; i++) {
			if('a' <= word[i] && word[i] <= 'z') {	// 소문자인 경우
				wordLower[word[i]-'a']++;
			} else {								// 대문자인 경우
				wordUpper[word[i]-'A']++;
			}
		}
		
		// str에서 word 길이만큼 문자열 계산
		int start = 0;	// 시작 0 index
		while(start <= strLength-wordLength) {
			boolean rightWord = true;
			for (int i = start; i < start+wordLength; i++) {
				if(!isCheckedRight(i)) {
					start = cutNextStr(i);
					rightWord = false;
					break;
				}
			}
			if(rightWord) {
				rightWordCnt++;
				start++;
				isCheckedLower = new int[26][2];
				isCheckedUpper = new int[26][2];
			}
		} // while start end
		System.out.println(rightWordCnt);
	} // main end
	
	public static boolean isCheckedRight(int index) {
		char letter = str[index];
		if('a' <= letter && letter <= 'z') {	// 소문자인 경우
			int tmp = letter-'a';
			if(isCheckedLower[tmp][0] == 0) {	// 받아온 letter가 첫 등장인 경우
				isCheckedLower[tmp][1] = index;
			}
			if(++isCheckedLower[tmp][0] > wordLower[tmp]) {
				return false;
			}
		} else {								// 대문자인 경우
			int tmp = letter-'A';
			if(isCheckedUpper[tmp][0] == 0) {	// 받아온 letter가 첫 등장인 경우
				isCheckedUpper[tmp][1] = index;
			}
			if(++isCheckedUpper[tmp][0] > wordUpper[tmp]) {
				return false;
			}
		}
		return true;
	}
	
	public static int cutNextStr(int index) {
		int nextStart = 0;
		char letter = str[index];
		
		if('a' <= letter && letter <= 'z') {	// 소문자인 경우
			nextStart = isCheckedLower[letter -'a'][1] + 1;
		} else {								// 대문자인 경우
			nextStart = isCheckedUpper[letter -'A'][1] + 1;
		}
		isCheckedLower = new int[26][2];
		isCheckedUpper = new int[26][2];
		
		return nextStart;
	}	
}
