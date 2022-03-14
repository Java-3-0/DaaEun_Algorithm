import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// bj 2605.줄 세우기
// 11604 kb
// 80 ms
public class Main {
	
	static int N;
	static Stack<Integer> stack = new Stack<Integer>();
	static Stack<Integer> tmp = new Stack<Integer>();
	static int student = 1;
	
	public static void main(String[] args) throws Exception {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				tmp.push(stack.pop());
			}
			stack.push(student++);
			for (int j = 0; j < num; j++) {
				stack.push(tmp.pop());
			}
		}
		for(int s : stack) {
			sb.append(s + " ");
		}
		System.out.println(sb.toString());
	}
}
