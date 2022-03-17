import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 11696 kb
// 80 ms
public class 잃어버린괄호_1541_Main {
	public static void main(String[] args) throws Exception {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split("[-]");
		
		// 더하기 연산 
		for(String input : inputs) {
			String[] addstr = input.split("[+]");
			int addNum = 0;
			for(String add : addstr) {
				addNum += Integer.parseInt(add);
			}
			stack.push(addNum);
		}
		
		// 빼기 연산
		int subNum = 0;
		while(!stack.isEmpty()) {
			int tmp = stack.pop();
			if(stack.isEmpty()) {
				subNum += tmp;
				continue;
			}
			subNum -= tmp;
		}
		System.out.println(subNum);
	}
}