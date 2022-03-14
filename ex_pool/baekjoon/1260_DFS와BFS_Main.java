package com.ssafy.bj_1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BJ 1260.DFS와 BFS
// 구현 방법 2. 직접 인접 리스트  Node[]
// 20604 kb
// 212 ms
public class Main2 {
	
	static class Node implements Comparable<Node>{
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.vertex - o.vertex;
		}		
	}
	
	static StringBuilder sb = new StringBuilder();
	static int N, M, V;
	static Node[] adjList;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		adjList = new Node[N+1];
		adjList[0] = new Node(0, null);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
//			while(true) {
//				if(adjList[from].link == null) {
//					adjList[from] = new Node(to, adjList[from]);
//				}
//				else if(to < adjList[from].link.vertex) {
//					adjList[form] = new Node(to, adjList[from]);
//					
//				}
//			}
			
		}
		for (int i = 0; i < N; i++) {
			System.out.println(adjList[i].toString());
		}
		System.out.println();
		Arrays.sort(adjList); // 
		for (int i = 0; i < N; i++) {
			System.out.println(adjList[i].toString());
		}
		dfs(new boolean[N+1], V);
		sb.append("\n");
		bfs(V);
		System.out.println(sb.toString());
	}
	
	public static void dfs(boolean[] visited, int current) {
		visited[current] = true;
		sb.append(current + " ");
		System.out.println("dfs : " + current);
		for (Node i = adjList[current]; i != null ; i = i.link) {
			if(!visited[i.vertex]) 
				dfs(visited, i.vertex);
		}
	}
	
	public static void bfs(int start) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			sb.append(current + " ");
			
			for (Node i = adjList[current]; i != null ; i = i.link) {
				if(!visited[i.vertex]) { 
					queue.offer(i.vertex);
					visited[i.vertex] = true;
				}
			}
		}
	}	
}
