package bj_10828;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 15316 kb, 152 ms
public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuffer sb = new StringBuffer();
		Stack<Integer> stack = new Stack<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			String order = st.nextToken();
			switch (order) {
			case "push":
				stack.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				sb.append((stack.empty() ? -1 : stack.pop()) + "\n");
				break;
			case "size":
				sb.append(stack.size() + "\n");
				break;
			case "empty":
				sb.append((stack.empty() ? 1 : 0) + "\n");
				break;
			case "top":
				sb.append((stack.empty() ? -1 : stack.peek()) + "\n");
				break;
			} // switch(order)-end
		} // for(n)-end
		System.out.println(sb.toString());
	}
}
