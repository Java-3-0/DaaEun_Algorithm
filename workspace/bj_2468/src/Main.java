import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	// 상 하 좌 우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N, cnt;
	static int[][] zone;
	static Queue<int[]> queue = new LinkedList<int[]>();
	
	public static void main(String[] args) throws Exception {
		
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < N; c++) {
				zone[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		
//		while(!queue.isEmpty()) {
//			System.out.println(Arrays.toString(queue.poll()));
//		}
	}
	
	public static void getCnt() {
		
		while(!queue.isEmpty()) {
			cnt++;
			getSafeZone(queue.poll());
		}
	}

	public static void getSafeZone(int[] safezone) {
		
		for (int i = 0; i < 4; i++) {
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
