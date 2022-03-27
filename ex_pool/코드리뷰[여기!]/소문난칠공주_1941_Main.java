import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 75488 kb
// 460 ms
public class 소문난칠공주_1941_Main {
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	
	static int[] girls = new int[25];
	static boolean[] isSelected = new boolean[25];
	static int[] paCnt = new int[2];	// 0 : 이다솜파 저장, 1 : 임도연파 저장 
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {
			char[] str = br.readLine().toCharArray();
			for (int j = 0; j < 5; j++) {
				girls[i*5+j] = str[j];
				if(str[j] == 'S') girls[i*5+j] = 0;	// 이다솜파인 경우, 0
				else girls[i*5+j] = 1;				// 임도연파인 경우 , 1
			}
		}
		
		combi(0, 0);
		System.out.println(answer);
	}
	
	// 25C7 구하기
	// 단, 임도연파 학생수가  4이상 될 경우 가지치기
	// 1. 이름이 이름인 만큼, 7명의 여학생들로 구성되어야 한다. -> 만족
	// 3. 화합과 번영을 위해, 반드시 ‘이다솜파’의 학생들로만 구성될 필요는 없다. -> 만족
	// 4. 그러나 생존을 위해, ‘이다솜파’가 반드시 우위를 점해야 한다. 
	// 따라서 7명의 학생 중 ‘이다솜파’의 학생이 적어도 4명 이상은 반드시 포함되어 있어야 한다. -> 만족
	public static void combi(int start, int cnt) {
		
		if(paCnt[1] == 4) return;
		
		if(cnt == 7) {
//			for (int i = 0; i < 25; i++) {
//				System.out.print(isSelected[i]? i : "X");	
//				System.out.print(" ");					
//			}
//			System.out.println();
			int[] seats = new int[7];
			int idx = 0;
			for (int i = 0; i < 25; i++) {
				if(isSelected[i]) seats[idx++] = i;
			}
			if(bfs(seats)) answer++;
			return;
		}
		
		
		for (int i = start; i < 25; i++) {
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			paCnt[girls[i]]++;
			combi(i+1, cnt+1);
			isSelected[i] = false;
			paCnt[girls[i]]--;
		}
	}
	
	// bfs
	// 2. 강한 결속력을 위해, 7명의 자리는 서로 가로나 세로로 반드시 인접해 있어야 한다.
	public static boolean bfs(int[] seats) {
		boolean isPossible = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] isVisited = new boolean[7];
		queue.offer(seats[0]);
		isVisited[0] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			int curR = cur/5;
			int curC = cur%5;
			
			for (int d = 0; d < 4; d++) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];
				
				for (int i = 0; i < 7; i++) {
					if(isVisited[i] == true || nr<0 || nr>=5 || nc<0 || nc>=5) continue;
					
					if(nr * 5 + nc == seats[i]) {
						queue.offer(seats[i]);
						isVisited[i] = true;
					}
				}
			}//4방탐색 end
		}//while end
		
		for(boolean is : isVisited) {
			if(!is) {
				isPossible = false;
				break;
			}
		}
		return isPossible;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
