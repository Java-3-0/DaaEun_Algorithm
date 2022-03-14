import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 21536 kb/ 200 ms
public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		int answer = 0;
		
		int K = Integer.parseInt(br.readLine());
		
		for (int k = 0; k < K; k++) {
			int money = Integer.parseInt(br.readLine());
			if(money == 0) {
				stack.pop();
				continue;
			}
			stack.push(money);
		}
		
		for(int s : stack) {
			answer += s;
		}
		System.out.println(answer);
	}
}
