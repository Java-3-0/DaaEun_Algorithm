import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

// BJ 2178. 미로탐색
public class Main_ty {
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   static StringTokenizer st;

   static int N, M, p1, p2;

   static Queue<int[]> q = new LinkedList<>();
   static int[][] board;
   static int[] coor;
   static String line;

   static int[] dx = { 0, 1, 0, -1 };
   static int[] dy = { 1, 0, -1, 0 };

   public static void main(String[] args) throws Exception {
      st = new StringTokenizer(br.readLine());

      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      board = new int[N][];

      for (int i = 0; i < N; i++) {
         line = br.readLine();
         board[i] = Stream.of(line.split("")).mapToInt(Integer::parseInt).toArray();
      }
      System.out.println(bfs(0, 0));
      for (int i = 0; i < N; i++) {
		System.out.println(Arrays.toString(board[i]));
	}

   }
   static int n = 0;
   public static int bfs(int x, int y) {
      // 1. 시작값 넣기
	  q.offer(new int[] { x, y });
	  
	  // 2. q가 빌 때까지
      while (!q.isEmpty()) {
         coor = q.poll();
         p1 = coor[0];
         p2 = coor[1];

         for (int i = 0; i < 4; i++) {
            int nx = p1 + dx[i];
            int ny = p2 + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M || board[nx][ny] == 0)
               continue;
            
            // (위 조건 성립)
            if (board[nx][ny] == 1) {
            	// 3. 새로운 값 넣기
               q.offer(new int[] { nx, ny });
               board[nx][ny] = board[p1][p2] + 1;
            }
         } // 4방탐색-end
         
         System.out.println(++n + "!!");
         for (int i = 0; i < N; i++) {
     		System.out.println(Arrays.toString(board[i]));
     	}
         
      } // while-end
      return board[N - 1][M - 1];
   }
}