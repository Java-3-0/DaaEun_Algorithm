import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 1966 프린터 큐
public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); 
			int M = Integer.parseInt(st.nextToken());
			int priorityM = 0;
			Queue<Integer> queue = new LinkedList<Integer>();
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
//				int tmp 
				queue.offer(Integer.parseInt(st.nextToken()));
			}
//			queue.contains(o)
			while(true) {
				
			}
		} //for(tc)-end
	}
}
