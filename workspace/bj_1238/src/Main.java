import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// BJ 1238.파티
// 16524 kb
// 152 ms
public class Main {
	
	static int N, M, X;
	
	static class Edge {
		int from, to, time;

		public Edge(int from, int to, int time) {
			super();
			this.from = from;
			this.to = to;
			this.time = time;
		}
	}
	
	static class Edge2 {
		int to, from, time;

		public Edge2(int to, int from, int time) {
			super();
			this.to = to;
			this.from = from;
			this.time = time;
		}
	}
	
	static class Vertex implements Comparable<Vertex>{
		int start, minTime;

		public Vertex(int start, int minTime) {
			super();
			this.start = start;
			this.minTime = minTime;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.minTime - o.minTime;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		ArrayList<Edge2>[] goEdges = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			goEdges[i] = new ArrayList<Edge2>();
		}
		ArrayList<Edge>[] backEdges = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			backEdges[i] = new ArrayList<Edge>();
		}
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			goEdges[to].add(new Edge2(to, from, time));
			backEdges[from].add(new Edge(from, to, time));
		}
		
		// X번 마을로 가는 경우
		// 1 -> 2
		// 2 -> 2
		// 3 -> 2
		// 4 -> 2
		boolean[] isVisited2 = new boolean[N+1];
		int[] goTime = new int[N+1];
		Arrays.fill(goTime, Integer.MAX_VALUE);
		PriorityQueue<Vertex> pQueue2 = new PriorityQueue<Vertex>();
		
		int start2 = X;
		goTime[start2] = 0;
		pQueue2.offer(new Vertex(start2, goTime[start2]));
		
		while(!pQueue2.isEmpty()) {
			Vertex cur = pQueue2.poll();
			int curTown = cur.start;
			int curTime = cur.minTime;
			isVisited2[curTown] = true;
			
			for (Edge2 edge : goEdges[curTown]) {
				if(!isVisited2[edge.from] && goTime[edge.from] > curTime + edge.time) {
					goTime[edge.from] = curTime + edge.time;
					pQueue2.offer(new Vertex(edge.from, goTime[edge.from]));
				}
			}
		}
//		System.out.println(Arrays.toString(goTime));	
		
		// 집으로 돌아가는 경우
		// 2 -> 1
		// 2 -> 2
		// 2 -> 3
		// 2 -> 4
		boolean[] isVisited = new boolean[N+1];
		int[] backTime = new int[N+1];
		Arrays.fill(backTime, Integer.MAX_VALUE);
		PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();
		
		int start = X;
		backTime[start] = 0;
		pQueue.offer(new Vertex(start, backTime[start]));
		
		while(!pQueue.isEmpty()) {
			Vertex cur = pQueue.poll();
			int curTown = cur.start;
			int curTime = cur.minTime;
			isVisited[curTown] = true;
			
			for (Edge edge : backEdges[curTown]) {
				if(!isVisited[edge.to] && backTime[edge.to] > curTime + edge.time) {
					backTime[edge.to] = curTime + edge.time;
					pQueue.offer(new Vertex(edge.to, backTime[edge.to]));
				}
			}
		}
//		System.out.println(Arrays.toString(backTime));	
		
		// 왕복시간 계산
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			answer = Math.max(answer, goTime[i] + backTime[i]);
		}
		System.out.println(answer);
	}
}
