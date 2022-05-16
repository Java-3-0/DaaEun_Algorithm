import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 58080 kb
// 540 ms
public class 운동_1956_Main {

	static int V, E;
	static final int INF = 4000001;
	static int[][] distance;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());	// 노드의 개수
		E = Integer.parseInt(st.nextToken());	// 간선의 개수
		
		// distance 선언 및 초기화
		distance = new int[V+1][V+1];
		for (int i = 0; i < V+1; i++) {
			Arrays.fill(distance[i], INF);
		}
		
		int start, end, weight;
		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			distance[start][end] = weight;
		}
		
//		for (int i = 1; i < V+1; i++) {
//			System.out.println(Arrays.toString(distance[i]));
//		}
		
		// 플로이드 와샬
		for(int k=1; k<V+1; ++k) {			// 경유지
			for(int i=1; i<V+1; ++i) {		// 출발지
				
				// 경유지와 출발지가 같은 경우
				if(i==k) continue;
				for(int j=1; j<V+1; ++j) {	// 목적지
					
					// 경유지와 목적지가 같거나 출발지가 곧 목적지인 경우
					if(i==j || k==j) continue; 
					
					// 최단 경로 계산
					distance[i][j] = Math.min(distance[i][j], distance[i][k]+distance[k][j]);
				}
			}
		}
		
//		for (int i = 1; i < V+1; i++) {
//			System.out.println(Arrays.toString(distance[i]));
//		}
		
		//사이클 확인
		for(int i=1; i<V+1; ++i) {		// 출발지
			for(int j=1; j<V+1; ++j) {	// 전환점
				// 출발지와 전환점이 같은 경우
				if(i==j) continue;
				distance[i][i] = Math.min(distance[i][i], distance[i][j] + distance[j][i]);
			}
		}
		
		int answer = INF;
		for(int i=1; i<V+1; ++i) {
			answer = Math.min(answer, distance[i][i]);
		}
		
		System.out.println(answer == INF ? -1 : answer);
	}
}
