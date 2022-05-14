import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 30000 kb
// 328 ms
public class 단어정렬_1181_Main {
	
	static class Word implements Comparable<Word>{
		String str;

		public Word(String str) {
			super();
			this.str = str;
		}

		@Override
		public int compareTo(Word o) {	// 길이 오름차순, 단어 사전순
			return this.str.length() != o.str.length() ? this.str.length() - o.str.length() : this.str.compareTo(o.str);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		List<Word> list = new ArrayList<Word>();
		for(String str : set) {
			list.add(new Word(str));
		}
		Collections.sort(list);
		
		for(Word word : list) {
			sb.append(word.str).append("\n");
		}
		System.out.println(sb);
	}
}
