package bj_1753;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// BJ 1753.최단경로
// 117832 kb
// 760 ms
public class Main {
	
	static class Edge{
		int v;
		int w;
		
		public Edge(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
	}
	
	static class Vertex implements Comparable<Vertex>{
		int no, minDistance;	// 정점번호, 출발지에서 자신으로의 최소비용

		public Vertex(int no, int minDistance) {
			super();
			this.no = no;
			this.minDistance = minDistance;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.minDistance - o.minDistance;
		}
	}
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		ArrayList<Edge>[] adjList = new ArrayList[V+1];	// 1 ~ V
		for (int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<Edge>();
		}
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adjList[u].add(new Edge(v, w));
//			adjList[v].add(new Edge(u, w));
		}
		
		int[] distance = new int[V+1];		// 출발지에서 자신으로 오는 최소비용
		boolean[] visited = new boolean[V+1];	// 최소비용 확정여부
		PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;	// 시작점 0으로
		pQueue.offer(new Vertex(start, distance[start]));
		
		while(!pQueue.isEmpty()) {
			// 1단계 : 최소비용이 확정되지 않은 정점 중 최소비용의 정점 선택
			Vertex current = pQueue.poll();
			
			if(visited[current.no]) continue;
			
			visited[current.no] = true;
			
			// 2단계 : 선택된 정점을 경유지로 하여 아직 최소비용이 확정되지 않은 다른 정점의 최소비용 고려
			for (int i = 0; i < adjList[current.no].size(); i++) {
				int adjListV = adjList[current.no].get(i).v;
				int adjListW = adjList[current.no].get(i).w;
				if(!visited[adjListV] && 
						distance[adjListV] > distance[current.no] + adjListW) {
					distance[adjListV] = distance[current.no] + adjListW;
					pQueue.offer(new Vertex(adjListV, distance[adjListV]));
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			if(distance[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
				continue;
			}
			sb.append(distance[i] + "\n");
		}
		System.out.println(sb.toString());
	}
}
