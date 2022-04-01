import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 문자열폭발_9935_Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		char[] bomb = br.readLine().toCharArray();
		
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length; i++) {
			stack.add(str[i]);
			
			if(stack.peek() == bomb[bomb.length-1]) {
				
			}
		}
	}
}
