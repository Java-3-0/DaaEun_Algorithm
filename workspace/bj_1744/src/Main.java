import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// BJ 1774.우주신과의 교감
// kb
// ms
public class Main {
	
	static class Pos{
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int start;
		double weight;
		
		public Edge(int start, double weight) {
			super();
			this.start = start;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			if(this.weight > o.weight) return 1;
			else if(this.weight == o.weight) return 0;
			else return -1;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Pos> pos = new ArrayList<Pos>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pos.add(new Pos(x,y));
		}
		
		double[][] adjmatrix = new double[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				double weight = Math.sqrt(Math.pow(pos.get(i).x - pos.get(j).x, 2) + Math.pow(pos.get(i).y - pos.get(j).y, 2));
				adjmatrix[i][j] = weight;
				adjmatrix[j][i] = weight;
			}
		}
		
		PriorityQueue<Edge> pQueue = new PriorityQueue<Edge>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			adjmatrix[from][to] = 0.00;
			adjmatrix[to][from] = 0.00;
		}
		
		boolean[] isVisited = new boolean[N];
		
		double minPath = 0;
		int cnt = 0;
		pQueue.offer(new Edge(0, 0.00));
		
		while(!pQueue.isEmpty()) {
			Edge cur = pQueue.poll();
			int curStart = cur.start;
			double curWeight = cur.weight;
			
			if(isVisited[curStart]) continue;
			
			isVisited[curStart] = true;
			minPath += curWeight;
			cnt++;
			
			if(cnt == N) break;
			
			for (int i = 0; i < N; i++) {
				if(!isVisited[i]) pQueue.offer(new Edge(i, adjmatrix[curStart][i]));
			}
		}
		System.out.printf("%.2f", minPath);
	}
}
