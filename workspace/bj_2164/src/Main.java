import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 2164 카드2
// 27628 kb
// 124 ms
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<Integer>();
		int N = Integer.parseInt(br.readLine());
		boolean turn = true;		// true = 버리기를 실행할 차례
		if(N%2 != 0) turn = false;	// false = 뒤로 보내기를 실행할 차례
		if(N == 1) {
			System.out.println(1);
			return;
		}
		for (int i = 2; i <= N; i+=2) {
			queue.offer(i);
		}
		while(true) {
			if(queue.size() == 1) {
				System.out.println(queue.poll());
				break;
			}
			
			if(turn) {	// true = 버리기를 실행할 차례
				queue.poll();
				turn = false;
			} else {	// false = 뒤로 보내기를 실행할 차례
				queue.offer(queue.poll());
				turn = true;
			}
		}
	}
}
