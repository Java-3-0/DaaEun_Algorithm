import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 스택 수열
public class Main {

	static StringBuffer sb = new StringBuffer();
	static Stack<Integer> stack = new Stack<Integer>();
	static int[] input;
	static int n;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		input = new int[n];

		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		isProgressed(0, 1);
		System.out.println(sb.toString());
	}

	private static void isProgressed(int idx, int num) {	// idx: input 값을 가져오기 위한 인덱스  n: stack에 담을 수

		if(idx == (n-1) && num == n && stack.empty()) return;
//		else if(num == n && !stack.empty()){
//			sb.delete(0, sb.length());
//			sb.append("NO");
//			return;
//		}

		if(stack.empty() || stack.peek() != input[idx]) {
			if(num == n) {
				sb.delete(0, sb.length());
				sb.append("NO");
				return;
			}
			stack.push(num);
			sb.append("+\n");
			System.out.println("+");
			isProgressed(idx, ++num);
		} else if(stack.peek() == input[idx]) {	// stack.peek() == input[idx]
			stack.pop();
			sb.append("-\n");
			System.out.println("-");
			isProgressed(++idx, num);
		
		}
	}
}
