import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

	static LinkedList<Integer> cryptogram = new LinkedList<Integer>();
	static int N, orders, x, y, s[];
	
	public static void main(String[] args) throws Exception {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringTokenizer st2 = null;
		
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				cryptogram.add(Integer.parseInt(st.nextToken()));
			}
			orders = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "I");
			for (int order = 0; order < orders; order++) {
				st2 = new StringTokenizer(st.nextToken(), " ");
				x = Integer.parseInt(st2.nextToken());
				y = Integer.parseInt(st2.nextToken());
				s = new int[y];
				for (int i = 0; i < y; i++) {
					s[i] = Integer.parseInt(st2.nextToken());
				}
				insertOrder();
			}
			sb.append("#"+ tc + " ");
			for (int i = 0; i < 10; i++) {
				sb.append(cryptogram.get(i) + " ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
			cryptogram.clear();
		} // for(tc)-end
		System.out.println(sb.toString());
	}

	private static void insertOrder() {
		for (int i = y-1; i >= 0; i--) {
			cryptogram.add(x,s[i]);
		}
	}
}