import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static StringBuilder sb = new StringBuilder();
	static int input, start, answer;
	static ArrayList<int[]> contact;
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			input = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());

			contact = new ArrayList<int[]>();
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < input/2; i++) {
				contact.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}
			bfs();
			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		Deque<int[]> deque = new LinkedList<int[]>();
		int[] isVisited = new int[101];
		
		queue.offer(new int[] {start, 0});
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			deque.offer(current);
			
			for (int i = 0; i < input/2; i++) {
				if(current[0] == contact.get(i)[0] && isVisited[contact.get(i)[1]] == 0) {
					queue.offer(new int[] {contact.get(i)[1], current[1]+1});
					isVisited[contact.get(i)[1]] = 1;
				}
			}
		}
		answer = 0;
		int cnt = deque.peekLast()[1]; 
		while(cnt == deque.peekLast()[1]) {
			answer = Math.max(answer, deque.pollLast()[0]);
		}
	}
}