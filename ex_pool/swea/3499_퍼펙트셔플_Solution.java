import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Solution {
	public static void main(String[] args) throws Exception {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		Queue<String> frontStack = new LinkedList<String>();
		Queue<String> backStack = new LinkedList<String>();
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			
			int alpha = 0;
			if(N%2 != 0) {
				alpha = 1;
			}
			for (int i = 0; i < N/2+alpha; i++) {
				frontStack.offer(st.nextToken());
			}
			for (int i = 0; i < N/2; i++) {
				backStack.offer(st.nextToken());
			}
			sb.append("#" + tc + " ");
			for (int i = 0; i < N/2; i++) {
				sb.append(frontStack.poll() + " " + backStack.poll() + " ");
			}
			if(alpha == 1) {
				sb.append(frontStack.poll() + " ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		} // for(tc)-end
		System.out.println(sb.toString());
	}
}