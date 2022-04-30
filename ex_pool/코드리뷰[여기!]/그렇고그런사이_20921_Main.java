import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 12884 kb
// 96 ms
public class 그렇고그런사이_20921_Main {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		calc(N-1, K, list);
		System.out.println(sb.toString());
	}
	
	public static void calc(int size, int cnt, ArrayList<Integer> list) {

		if(size < cnt) {
			sb.append(list.get(size)).append(" ");
			list.remove(size);
			calc(size-1, cnt-size, list);
		} else {
			sb.append(list.get(cnt)).append(" ");
			list.remove(cnt);
			for (int i = 0; i < list.size(); i++) {
				sb.append(list.get(i)).append(" ");
			}
		}
	}
}