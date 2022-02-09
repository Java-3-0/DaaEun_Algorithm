import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 18258 큐2
// 338572 kb
// 1032 ms
public class Main {
	public static void main(String[] args) throws Exception {

		Queue<Integer> queue = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());

		int pre = 0;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");

			switch (st.nextToken()) {
			case "push":
				pre = Integer.parseInt(st.nextToken());
				queue.offer(pre);
				break;
			case "pop":
				sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
				break;
			case "size":
				sb.append(queue.size()).append("\n");
				break;
			case "empty":
				sb.append(queue.isEmpty() ? 1 : 0).append("\n");
				break;
			case "front":
				sb.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
				break;
			case "back":
				sb.append(queue.isEmpty() ? -1 : pre).append("\n");
				break;
			} // switch(st.nextToken()) - end
		} // for(n) - end
		System.out.println(sb.toString());
	}
}
