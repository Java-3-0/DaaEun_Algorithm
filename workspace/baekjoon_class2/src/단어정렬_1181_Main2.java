import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

// 28628 kb
// 264 ms
public class 단어정렬_1181_Main2 {
	
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
		
		Set<Word> set = new TreeSet<Word>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			set.add(new Word(str));
		}
		for(Word word : set) {
			sb.append(word.str).append("\n");
		}
		System.out.println(sb);
	}
}
