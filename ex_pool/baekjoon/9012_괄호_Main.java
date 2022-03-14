
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// BJ 9012.괄호
// 11732 kb	
// 80 ms
public class Main {

	public static void main(String[] args) throws Exception {
		
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			char[] brackets = br.readLine().toCharArray();
			
			sb.append(isChecked(brackets) + "\n");
		}
		System.out.println(sb.toString());
	}
	
	private static String isChecked(char[] brackets) {
		Stack<Character> stack = new Stack<Character>();
		
		for(char bracket : brackets) {
			switch (bracket) {
			case '(': 
				stack.push(bracket);
				break;
			case ')':
				if(stack.empty() || stack.peek() != '(') return "NO";
				else stack.pop();
				break;
			}
		}
		if(!stack.empty()) return "NO";
		return "YES";
	}
}