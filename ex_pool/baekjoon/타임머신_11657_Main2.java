import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// kb
// ms
// 입력 간선을 정렬하고, 반복횟수를 줄일 수 있지 않을까?
// 결론, 안됨!!
// 1 -> 8 , 2-> 3.. 등 이런 경우에서 에러 발생
public class 타임머신_11657_Main2 {
	
	static class Node implements Comparable<Node>{
		int start, end, dis;

		public Node(int start, int end, int dis) {
			super();
			this.start = start;
			this.end = end;
			this.dis = dis;
		}

		@Override
		public int compareTo(Node o) {
			return this.start != o.start ? this.start - o.start : this.end - o.end;
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
		Arrays.sort(node);
		
		//벨만-포드 알고리즘
		long[] distance = new long[N+1];
		Arrays.fill(distance, Long.MAX_VALUE);
		distance[1] = 0;
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < M; j++) {
				int start = node[j].start;
				int end = node[j].end;
				int dis = node[j].dis;
				
				if(distance[start] == Long.MAX_VALUE) continue;
				
				if(distance[end] > distance[start] + dis) {
					distance[end] = distance[start] + dis;
					
					if(i == 1) {	// 음의 사이클
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
