import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// BJ 1446.지름길
// kb
// ms
public class Main {
	
	static class Edge implements Comparable<Edge>{
		int from, to, minDistance;

		public Edge(int from, int to, int minDistance) {
			super();
			this.from = from;
			this.to = to;
			this.minDistance = minDistance;
		}

		@Override
		public int compareTo(Edge o) {
			return this.minDistance - o.minDistance;
		}
	}
	
	static int N, D;
	static ArrayList<Edge> edgeList = new ArrayList<Edge>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());		// 시작 위치
			int to = Integer.parseInt(st.nextToken());			// 도착 위치
			int shortcut = Integer.parseInt(st.nextToken());	// 지름길의 길이
			if(to > D) continue;
			
			edgeList.add(new Edge(from, to, shortcut));
			edgeList.add(new Edge(from, to, to-from));
		}
		
		Collections.sort(edgeList);
		for (Edge edge : edgeList) {
			System.out.println(edge.from + " " + edge.to + " " + edge.minDistance);
		}

		int[] distance = new int[D];		// 출발지에서 자신으로 오는 최소비용
		boolean[] visited = new boolean[D];	// 최소비용 확정여부
		PriorityQueue<Edge> pQueue = new PriorityQueue<Edge>();
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		int start = 0;
		distance[start] = 0;	// 시작점 0으로
		pQueue.offer(new Edge(start, end, distance[start]));
		
		while(!pQueue.isEmpty()) {
			// 1단계 : 최소비용이 확정되지 않은 정점 중 최소비용의 정점 선택
			Edge current = pQueue.poll();
			
			if(visited[current.no]) continue;	// 코드 추가하지 않아도, 잘 수행됨. --> 그래도 아래 불필요한 동작과정 할 필요없어짐
			
			visited[current.no] = true;
			
			// 2단계 : 선택된 정점을 경유지로 하여 아직 최소비용이 확정되지 않은 다른 정점의 최소비용 고려
			for (int j = 0; j < V; j++) {
				if(!visited[j] && adjMatrix[current.no][j] != 0 && 
						distance[j] > distance[current.no] + adjMatrix[current.no][j]) {
					distance[j] = distance[current.no] + adjMatrix[current.no][j];
					pQueue.offer(new Vertex(j, distance[j]));
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
