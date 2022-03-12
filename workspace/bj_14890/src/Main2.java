import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BJ 14890.경사로
// kb
// ms
public class Main {
	
	static int N, L, iCanGoCnt;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		int[][] map2 = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				map2[j][i] = map[i][j];
			}
		}
		canGo(map);
		System.out.println("map2");
		canGo(map2);
		System.out.println();
		System.out.println(iCanGoCnt);
	}
	public static void canGo(int[][] map) {
		
	} 
}