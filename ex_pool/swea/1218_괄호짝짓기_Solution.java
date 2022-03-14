import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			int len = Integer.parseInt(br.readLine());
			char[] brackets = br.readLine().toCharArray();
			
			sb.append("#" + tc + " " + isChecked(len, brackets) + "\n");
		}
		System.out.println(sb.toString());
	}

	private static int isChecked(int len, char[] brackets) {
		Stack<Character> stack = new Stack<Character>();
		
		for(char bracket : brackets) {
			switch (bracket) {
			case '(': case '[': case '{': case '<':
				stack.push(bracket);
				break;
			case ')':
				if(stack.empty() || stack.peek() != '(') return 0;
				else stack.pop();
				break;
			case ']':
				if(stack.empty() || stack.peek() != '[') return 0;
				else stack.pop();
				break;
			case '}':
				if(stack.empty() || stack.peek() != '{') return 0;
				else stack.pop();
				break;
			case '>':
				if(stack.empty() || stack.peek() != '<') return 0;
				else stack.pop();
				break;
			}
		}
		
		if(!stack.empty()) return 0;
		return 1;
	}
}