import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class swea_3124_최소스패닝트리_Solution {
	
	static class Edge implements Comparable<Edge>{
		int vertex, dis;

		public Edge(int vertex, int dis) {
			super();
			this.vertex = vertex;
			this.dis = dis;
		}

		@Override
		public int compareTo(Edge o) {
			return this.dis - o.dis;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			ArrayList<Edge>[] edgeList = new ArrayList[E+1];
			for (int i = 0; i < E+1; i++) {
				edgeList[i] = new ArrayList<Edge>();
			}
			for (int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edgeList[start].add(new Edge(end, weight));
				edgeList[end].add(new Edge(start, weight));
			}
			
			PriorityQueue<Edge> pqueue = new PriorityQueue<Edge>();
			boolean[] isVisited = new boolean[V+1];
			
			pqueue.offer(new Edge(1, 0));
			long result = 0;
			int cnt = 0;
			
			while(!pqueue.isEmpty()) {
				Edge cur = pqueue.poll();
				int curV = cur.vertex;
				int curD = cur.dis;
				
                if(isVisited[curV]) continue;
				isVisited[curV] = true;
				result += curD;
				cnt++;
                
				if(cnt == V) break;
				
				for (Edge edge : edgeList[curV]) {
					int nextV = edge.vertex;
					int nextD = edge.dis;
					if(!isVisited[nextV]) {
						pqueue.offer(new Edge(nextV, nextD));
					}
				}
			}
			sb.append("#" + tc + " " + result + "\n");
		}//for tc end
		System.out.println(sb.toString());
	}
}