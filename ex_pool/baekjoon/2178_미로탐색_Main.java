import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BJ 2178. 미로탐색
// 12256 kb
// 92 ms
public class Main {

	// 상 하 좌 우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	
	static int N, M;
	static int[][] maze;
	static Queue<int[]> queue = new LinkedList<int[]>(); 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maze = new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] str = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				maze[i][j] = str[j] - '0';
			}
		}
		System.out.println(bfs(0,0));
	}

	private static int bfs(int x, int y) {
		
		queue.add(new int[] {x, y});
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int prex = temp[0];
			int prey = temp[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = prex + dx[i];
				int ny = prey + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || maze[nx][ny] == 0 ) continue;
				// 방문하지 않은 경우만!
				if(maze[nx][ny] == 1) {
					queue.add(new int[] {nx, ny});
					maze[nx][ny] += maze[prex][prey];
				}
			}
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(maze[i]));
//			}
		} //while-end
		return maze[N-1][M-1];
	}	
}
