import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// BJ 1715.카드 정렬하기 
// 24756 kb
// 368 ms
public class Main {
	
	static int N, answer;
	static PriorityQueue<Integer> card = new PriorityQueue<Integer>();	// 최소힙
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			card.offer(Integer.parseInt(br.readLine()));
		}
		
		while(card.size() > 1) {
			int cardSet = card.poll() + card.poll();
			answer += cardSet;
			card.offer(cardSet);
		}
		System.out.println(answer);
	}
}
