import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BJ 17281.야구공
// kb
// ms
// 시간초과가 계속난다... 박기우 내일 두고보자 ㅂㄷㅂㄷ
public class Main {
	
	static int N;
	static int[] hitOrder;
	static int[][] inning;
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		inning = new int[N][9];
		hitOrder = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
		
		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				inning[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int maxScore = Integer.MIN_VALUE;
		do {
			//타순 결정
			int[] realHitOrder = new int[9];
			int j = 0;
			for (int i = 0; i < 9; i++) {
				if(i == 3) {
					realHitOrder[i] = 0;
					continue;
				}
				realHitOrder[i] = hitOrder[j++];
			}
			// 경기하기
			int tempScore = playGame(realHitOrder);
			maxScore = Math.max(maxScore, tempScore);
		} while(NextPermutation());
		System.out.println(maxScore);
	}
	
	public static boolean NextPermutation() {
		// 1. 교환위치 찾기
		int i = 7;
		while(i > 0 && hitOrder[i-1] >= hitOrder[i]) --i;
		// i가 0과 같은 경우
		if(i == 0) return false;
		// 2. 교환위치에 교환할 값 찾기
		int j = 7;
		while(hitOrder[i-1] >= hitOrder[j]) --j;
		// 3. 교환위치와 교환할 값 교환하기
		swap(i-1, j);
		// 4. 교환위치 뒤(꼭대기)부터 맨 뒤까지 만들 수 있는 가장 작은 순열 생성(오름차순 정렬)
		int k = 7;
		while(i < k) {
			swap(i++,k--);
		}
		return true;
	}
	
	public static void swap(int i, int j) {
		int temp = hitOrder[i];
		hitOrder[i] = hitOrder[j];
		hitOrder[j] = temp;
	}
	
	public static int playGame(int[] realHitOrder) {
		
		int idx = -1;
		int score = 0;
		for (int i = 0; i < N; i++) {
			// 초기화
			Queue<Integer> queue = new LinkedList<Integer>();	//  야구장 타석 위치
			for (int j = 0; j < 3; j++) queue.offer(0);
			int outCnt = 0;
			// 이닝별 경기 진행
			while(outCnt < 3) {
				idx = ++idx % 9;
				int player = inning[i][realHitOrder[idx]];
				if(player == 0) outCnt++;
				else {
					queue.offer(1);
					for (int j = 0; j < player; j++) {
						score += queue.poll();
						if (j == player-1) break;
						queue.offer(0);
					}
				}
			} //while outCnt end
		} //for i end
		return score;
	}	
}