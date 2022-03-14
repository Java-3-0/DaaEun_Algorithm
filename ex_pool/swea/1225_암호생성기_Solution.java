import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static Queue<Integer> queue= new LinkedList<Integer>();
	static int tmp;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = null;
		
		String strTc = "";
		while((strTc = br.readLine()) != null) {
			int tc = Integer.parseInt(strTc);
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			makePwd();
			
			sb.append("#" + tc + " ");
			for (int i = 0; i < 8; i++) {
				sb.append(queue.poll() + " ");
			}
			sb.append("\n");
		} // while-end
		System.out.println(sb.toString());
	}
	
	private static void makePwd() {
		int minus = 0;
		while(true) {
			minus = minus%5 + 1;
			tmp = queue.poll() - minus;
			if(tmp <= 0) {	
				queue.offer(0);
				break;
			}
			queue.offer(tmp);
		} // while-end
	}
}