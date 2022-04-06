import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643_키순서_양다은 {
	
	static int N, M;
	static int[][] adjMatrix;


	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			adjMatrix = new int[N+1][N+1];
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine(), " ");
				int shortK = Integer.parseInt(st.nextToken());
				int tallK = Integer.parseInt(st.nextToken());
				
				adjMatrix[shortK][tallK] = 1;
			}
			
			int answer = 0;
			for (int n = 1; n <= N; n++) {
				int tallCnt = CalcTallCnt(n);
				int shortCnt = CalcShortCnt(n);
				if(tallCnt + shortCnt + 1 == N) answer++;
			}
			sb.append("#" + tc + " " + answer + "\n");
		}//for tc end
		System.out.println(sb.toString());
	}
	
	public static int CalcTallCnt(int n) {
		int tallCnt = 0;
		boolean[] isVisited = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(n);
		isVisited[n] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 1; i <= N; i++) {
				if(!isVisited[i] && adjMatrix[cur][i] == 1) {
					queue.offer(i);
					isVisited[i] = true;
					tallCnt++;
				}
			}
		}
		return tallCnt;
	}
	
	public static int CalcShortCnt(int n) {
		int shortCnt = 0;
		boolean[] isVisited = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(n);
		isVisited[n] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 1; i <= N; i++) {
				if(!isVisited[i] && adjMatrix[i][cur] == 1) {
					queue.offer(i);
					isVisited[i] = true;
					shortCnt++;
				}
			}
		}
		return shortCnt;
	}
}
