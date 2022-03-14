import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Vertex implements Comparable<Vertex>{
		int to;
		double weight;
		
		public Vertex(int to, double weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			if(this.weight > o.weight) return 1;
			else if(this.weight == o.weight) return 0;
			else return -1;
		}
	}
	
	static class Pos{
		double x, y;

		public Pos(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Pos[] star = new Pos[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			star[i] = new Pos(x, y);
		}
		
		double[][] distance = new double[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				double dist = Math.sqrt(Math.pow((star[i].x - star[j].x),2) + Math.pow((star[i].y - star[j].y),2));
				distance[i][j] = dist;
				distance[j][i] = dist;
			}
		}
		
		double answer = 0.00;
		int cnt = 0;
		boolean[] isVisited = new boolean[n];
		
		PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();
		pQueue.add(new Vertex(0, 0.00));
		
		while(!pQueue.isEmpty()) {
			Vertex cur = pQueue.poll();
			int curS = cur.to;
			double curW = cur.weight;
			
			if(isVisited[curS]) continue;
			isVisited[curS] = true;
			cnt++;
			answer += curW;
			
			if(cnt == n) break;
			
			for (int i = 0; i < n; i++) {
				if(!isVisited[i] && distance[curS][i] != 0.00) {
					pQueue.add(new Vertex(i, distance[curS][i]));
				}
			}
		}
		System.out.printf("%.2f", answer);
	}
}
