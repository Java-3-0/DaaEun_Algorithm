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
// 11716 kb
// 80 ms
public class Main {
	
	static class Edge implements Comparable<Edge>{
		int from, to, shortcut;

		public Edge(int from, int to, int shortcut) {
			super();
			this.from = from;
			this.to = to;
			this.shortcut = shortcut;
		}

		@Override
		public int compareTo(Edge o) {
			return this.from != o.from ? this.from - o.from : this.to - o.to;
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
		}
		
		Collections.sort(edgeList);
//		for (Edge edge : edgeList) {
//			System.out.println(edge.from + " " + edge.to + " " + edge.shortcut);
//		}

		int[] distance = new int[D+1];		// 출발지에서 자신으로 오는 최소비용
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		int start = 0;
		distance[start] = 0;
		
		for (Edge edge : edgeList) { // 지름길 갯수
			int from = edge.from;
			int to = edge.to;
			int shortcut = edge.shortcut;
			for (int j = start; j < D; j++) {	//이동거리 
				if(j == from) {
					int temp = distance[j] + shortcut;
					if(distance[to] > temp) {
						distance[to] = temp;
						start = j;
						break;
					}
				}
				distance[j+1] = Math.min(distance[j+1], distance[j]+1);
				
			}//for j end
//			System.out.println(Arrays.toString(distance));
		}//for edge end
		for (int j = start; j < D; j++) {
			distance[j+1] = Math.min(distance[j+1], distance[j]+1);
		}
//		System.out.println(Arrays.toString(distance));
		System.out.println(distance[D]);
	}
}
