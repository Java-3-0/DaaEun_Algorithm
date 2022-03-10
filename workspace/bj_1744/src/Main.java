import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
		int from, to;
		int weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	static int N, M;
	static int[] parents;
	static ArrayList<Edge> edgeList;
	
	// 단위집합 생성
	public static void makeSet() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	// a의 집합 찾기 : a의 대표자 찾기
	public static int findSet(int a) {
		if(a == parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	// a, b 두 집합 합치기
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ArrayList<Pos> pos = new ArrayList<Pos>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pos.add(new Pos(x,y));
		}
		
		ArrayList<Edge> alreadyEdge = new ArrayList<Edge>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			alreadyEdge.add(new Edge(Math.min(from, to), Math.max(from, to), 0));
		}
		
		edgeList = new ArrayList<Edge>();
		for (int i = 0; i < N; i++) {
			for(Edge aEdge : alreadyEdge) {
				for (int j = i+1; j < N; j++) {
					int weight = 0;
					if(aEdge.from != i || aEdge.to == j) {
						continue;
					} else {
						int weight = (int) (Math.pow((pos.get(i).x-pos.get(j).x), 2) + Math.pow((pos.get(i).y-pos.get(j).y), 2));
					}
					edgeList.add(new Edge(i+1, j+1, weight));
				}
			}
		}
		
		Collections.sort(edgeList);
		makeSet();
		
		int result = 0;
		int cnt = 0;
		
		for(Edge edge : edgeList) {
			if(un)
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
