import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Kruskal알고리즘이 아닌 Prim 알고리즘 선택
public class Solution {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// TC : 전체 테스트 케이스 수
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			
			// N : 섬(정점) 개수
			int N = Integer.parseInt(br.readLine());
			// X : 각 섬들의 정수인 X 좌표 배열
			int[] X = new int[N];
			// Y : 각 섬들의 정수인 Y 좌표 배열
			int[] Y = new int[N];
			
			// X 좌표 입력받기
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				X[i] = Integer.parseInt(st.nextToken());
			}
			// Y 좌표 입력받기
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				Y[i] = Integer.parseInt(st.nextToken());
			}
			
			// E : 해저터널 건설의 환경 부담 세율 실수
			double E = Double.parseDouble(br.readLine());
			
			// adjMatrix : 각 섬간의 해저터널 환경 부담금(가중치)
			double[][] adjMatrix = new double[N][N];
			// minEdge : 타정점에서 자신으로의 가중치 중 최소
			double[] minEdge = new double[N];
			// 해당 정점 선택 여부
			boolean[] isVisited = new boolean[N];
			// 가중치 계산 L^2 = (x-x')^2 + (y-y')^2
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					adjMatrix[i][j] = Math.pow((X[i] - X[j]), 2) + Math.pow((Y[i] - Y[j]), 2);
				}
				minEdge[i] = Double.MAX_VALUE;
			}

			// result : MST 
			double result = 0;
			minEdge[0] = 0;	// 0번부터 선택
			
			// prim알고리즘을 이용한 정점 연결
			for (int n = 0; n < N; n++) {
				// 최소 가중치
				double min = Double.MAX_VALUE;
				// 최소 가중치의 정점
				int minVertex = 0;
				
				for (int i = 0; i < N; i++) {
					// 해당 정점을 트리에 포함하지 않은 경우 && 해당 정점 가중치가 최소 가중치보다 작은 경우
					if(!isVisited[i] && minEdge[i] < min) {
						min = minEdge[i];
						minVertex = i;
					}
				}
				
				isVisited[minVertex] = true;	// 선택된 정점을 트리에 포함
				result += min;					// 가중치 누적
				
				for (int i = 0; i < N; i++) {
					// 해당 정점을 트리에 포함하지 않은 경우 
					// 해당 정점과 연결이 가능한 가중치인 경우
					// 해당 정점과의 가중치가 현재 최소 가중치보다 작은 경우
					if(!isVisited[i] && adjMatrix[minVertex][i] != 0 && adjMatrix[minVertex][i] < minEdge[i]) {
						minEdge[i] = adjMatrix[minVertex][i];
					}
				}
			} // N개의 정점을 모두 트리에 포함하기-끝
			sb.append("#" + tc + " " + Math.round(result * E) + "\n");
		} // for(tc)-end
		System.out.println(sb.toString());
	}	
}