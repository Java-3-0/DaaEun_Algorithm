import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 16592 kb
// 220 ms
public class 타임머신_11657_Main {
	
	static class Node {
		int start, end, dis;

		public Node(int start, int end, int dis) {
			super();
			this.start = start;
			this.end = end;
			this.dis = dis;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Node[] node = new Node[M];
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			node[m] = new Node(start, end, dis);
		}
		
		//벨만-포드 알고리즘
		long[] distance = new long[N+1];
		Arrays.fill(distance, Long.MAX_VALUE);
		distance[1] = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int start = node[j].start;
				int end = node[j].end;
				int dis = node[j].dis;
				
				if(distance[start] == Long.MAX_VALUE) continue;
				
				if(distance[end] > distance[start] + dis) {
					distance[end] = distance[start] + dis;
					
					if(i == N-1) {	// 음의 사이클
						System.out.println(-1);
						return;
					}
				}
			}//for M end
		}//for N end

		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++)  {
			if(distance[i] == Long.MAX_VALUE) sb.append(-1).append("\n");
			else sb.append(distance[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
