import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 25692 kb
// 140 ms
public class Solution_1953_탈주범검거_양다은 {
   
   // 상 하 좌 우
   static int[] dr = {-1, 1, 0, 0};
   static int[] dc = {0, 0, -1, 1};
   static int N, M, R, C, L, answer;
   static int[][] map;
   
   static int[] d;
   static boolean[][] isVisited;
   
   static class Vertex {
      int r, c, tunnel;

      public Vertex(int r, int c, int tunnel) {
         super();
         this.r = r;
         this.c = c;
         this.tunnel = tunnel;
      }
   }
   
   public static void main(String[] args) throws NumberFormatException, IOException {
      StringTokenizer st = null;
      StringBuilder sb = new StringBuilder();
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int TC = Integer.parseInt(br.readLine());
      
      for (int tc = 1; tc <= TC; tc++) {
         st = new StringTokenizer(br.readLine(), " ");
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         R = Integer.parseInt(st.nextToken());
         C = Integer.parseInt(st.nextToken());
         L = Integer.parseInt(st.nextToken());
         
         map = new int[N][M];
         for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int m = 0; m < M; m++) {
               map[n][m] = Integer.parseInt(st.nextToken());
            }
         }
         
         answer = 0;
         isVisited = new boolean[N][M];
         Queue<Vertex> pqueue = new LinkedList<Vertex>();
         pqueue.offer(new Vertex(R, C, map[R][C]));
         escape(0, pqueue);
         
         sb.append("#").append(tc).append(" ").append(answer).append("\n");
      }// for tc end
      System.out.println(sb.toString());
   }
   
   public static void escape(int t, Queue<Vertex> pqueue) {
	   
      if(t == L) return;
      
      Queue<Vertex> nextPQ = new LinkedList<Vertex>();
      
      while(!pqueue.isEmpty()) {
         Vertex cur = pqueue.poll();
         
         if(isVisited[cur.r][cur.c]) continue;
         isVisited[cur.r][cur.c] = true;
         answer++;
         
         switch (cur.tunnel) {
         case 1:
            d = new int[] {0, 1, 2, 3}; 
            break;
         case 2:
            d = new int[] {0, 1};
            break;
         case 3:
            d = new int[] {2, 3};
            break;
         case 4:
            d = new int[] {0, 3};
            break;
         case 5:
            d = new int[] {1, 3};
            break;
         case 6:
            d = new int[] {1, 2};
            break;
         case 7:
            d = new int[] {0, 2};
            break;
         }//switch end
         runNextTunnel(cur.r, cur.c, d, nextPQ);
      }// while end
      escape(t+1, nextPQ);
   }
   
   public static boolean isCheckedRange(int r, int c) {
      if(r>=0 && c>=0 && r<N && c<M && map[r][c]>0 && !isVisited[r][c]) return true;
      return false;
   }
   
   public static void runNextTunnel(int curR, int curC, int[] ds, Queue<Vertex> nextPQ) {
      for (int d : ds) {
         int nr = curR + dr[d];
         int nc = curC + dc[d];
         if(!isCheckedRange(nr, nc)) continue;
         int curTunnel = map[nr][nc];
         boolean flag = false;
         switch (d) {
         case 0:
         if(curTunnel == 1 || curTunnel == 2 || 
            curTunnel == 5 || curTunnel == 6) flag = true;
         break;
         case 1:
          if(curTunnel == 1 || curTunnel == 2 || 
             curTunnel == 4 || curTunnel == 7) flag = true;
          break;
         case 2:
           if(curTunnel == 1 || curTunnel == 3 || 
              curTunnel == 4 || curTunnel == 5) flag = true;
           break;
         case 3:
            if(curTunnel == 1 || curTunnel == 3 || 
               curTunnel == 6 || curTunnel == 7) flag = true;
            break;
      }
         if(flag) nextPQ.offer(new Vertex(nr, nc, map[nr][nc]));
      }
   }   
}