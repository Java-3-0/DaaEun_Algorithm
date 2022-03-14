import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 17528 kb,	184 ms
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		while(true) {
			Stack<Character> bracket = new Stack<Character>();
			char[] str = br.readLine().toCharArray();
			if(str[0] == '.') break;
			
			for (char s : str) {
				// 1. ( [ 
				if (s == '(' || s == '[') bracket.push(s);
				// 2. )
				else if (s == ')') {
					if(bracket.empty()) {
						bracket.push(s);
						break;
					} else if (!bracket.empty() && bracket.peek() == '(') bracket.pop();
					else break;
				// 3. ]	
				}else if (s == ']') {
					if(bracket.empty()) {
						bracket.push(s);
						break;
					} else if (!bracket.empty() && bracket.peek() == '[') bracket.pop();
					else break;
				}
			}
			sb.append((bracket.empty() ? "yes" : "no") + "\n");
		}
		System.out.println(sb.toString());
	}
}