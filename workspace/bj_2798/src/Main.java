import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 블랙잭  */
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] cards = new int[N];

		st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(blackJack(cards, N, M));
	}

	// 완전탐색 알고리즘
	private static int blackJack(int[] cards, int N, int M) {
		int answer = 0;

		for (int i = 0; i < N - 2; i++) {
			
			if(cards[i] > M) continue;	// 첫번째 카드가 M보다 크면 다음 카드로 진행
			int tmp = cards[i];
			
			for (int j = i + 1; j < N - 1; j++) {
				
				if(tmp + cards[j] > M) continue;	// 첫번째, 두번째 카드 합이 M보다 크면 다음 카드로 진행
				tmp += cards[j];
				
				for (int k = j + 1; k < N; k++) {
					
					if(tmp + cards[k] > M) continue;	// 첫번째, 두번째, 세번째 카드 합이 M보다 크면 다음 카드로 진행
					tmp += cards[k];
					if(tmp == M) return tmp;	// 세 카드의 합이 M과 같으면 빠른 종료
					else if(answer < tmp && tmp < M) answer = tmp;	// 세 카드의 합을 answer에 업데이트
					tmp -= cards[k];
				}
				tmp -= cards[j];
			}
		}
		return answer;
	}
}