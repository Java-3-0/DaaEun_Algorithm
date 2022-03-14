import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 17298 오큰수
// 319972 kb
// 1216 ms
public class Main {

	public static void main(String[] args) throws Exception {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<int[]> aElement = new Stack<int[]>();
		Stack<int[]> stack = new Stack<int[]>();
		int[] answer = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			aElement.push(new int[]{i, Integer.parseInt(st.nextToken())});
		}
		
		while(!aElement.empty()) {
			int[] tmp = aElement.pop();
			if(stack.empty()) {
				answer[tmp[0]] = -1;
				stack.push(tmp);
			} else if(tmp[1] < stack.peek()[1]) {
				answer[tmp[0]] = stack.peek()[1];
				stack.push(tmp);
			} else {
				stack.pop();
				aElement.push(tmp);
			}
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(answer[i] + " ");
		}
		System.out.println(sb.toString());
	}
}
