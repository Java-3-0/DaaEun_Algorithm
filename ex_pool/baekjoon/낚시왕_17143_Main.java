import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 43232 kb
// 496 ms
public class Main_17143_낚시왕_양다은 {
	
	static int R, C, M, fishing;
	static List<Shark>[] shark;
	
	static class Shark implements Comparable<Shark>{
		int r, c, s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public int compareTo(Shark o) {
			return this.r != o.r ? this.r - o.r : o.z - this.z;
		}
	}

	static int sameMoveR, diffMoveR;
	static int sameMoveC, diffMoveC;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		shark = new ArrayList[C+1];
		for (int c = 1; c <= C; c++) {
			shark[c] = new ArrayList<Shark>();
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			shark[c].add(new Shark(r, c, s, d, z));
		}
		
		for (int c = 1; c <= C; c++) {
			Collections.sort(shark[c]);
		}
		
		sameMoveR = 2 * (R - 1);
		sameMoveC = 2 * (C - 1);
		
		// 1.낚시왕이 오른쪽으로 한 칸 이동한다.
		for (int c = 1; c <= C; c++) {
			
			// 2.낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다.상어를 잡으면 격자판에서 잡은 상어가 사라진다.
			// 해당 열에 상어가 존재하지 않는 경우
			if(!shark[c].isEmpty()) {
				fishing += shark[c].get(0).z;
//				System.out.println(shark[c].get(0).z);
				shark[c].remove(0);
			}
			
			// 3.상어가 이동한다.
			move();
		}
		
		System.out.println(fishing);
	}
	
	public static void move() {
		
		List<Shark>[] shark2 = new ArrayList[C+1];
		for (int c = 1; c <= C; c++) {
			shark2[c] = new ArrayList<Shark>();
		}
		
		
		for (int c = 1; c <= C; c++) {	
			for (int i = 0; i < shark[c].size(); i++) {
				
				Shark cur = shark[c].get(i);
				switch (cur.d) {
				case 1:
					diffMoveR = cur.s % sameMoveR;
					if(diffMoveR <= cur.r - 1) { cur.r -= diffMoveR; break; }
					diffMoveR -= cur.r - 1;
					cur.d = 2;
					if(diffMoveR <= R - 1) { cur.r = diffMoveR + 1; break; }
					diffMoveR -= R - 1;
					cur.d = 1;
					cur.r = R - diffMoveR;
					break;
				case 2:
					diffMoveR = cur.s % sameMoveR;
					if(diffMoveR <= R - cur.r) { cur.r += diffMoveR; break; }
					diffMoveR -= R - cur.r;
					cur.d = 1;
					if(diffMoveR <= R - 1) { cur.r = R - diffMoveR; break; }
					diffMoveR -= R - 1;
					cur.d = 2;
					cur.r = diffMoveR + 1;
					break;
				case 3:
					diffMoveC = cur.s % sameMoveC;
					if(diffMoveC <= C - cur.c) { cur.c += diffMoveC; break; }
					diffMoveC -= C - cur.c;
					cur.d = 4;
					if(diffMoveC <= C - 1) { cur.c = C - diffMoveC; break; }
					diffMoveC -= C - 1;
					cur.d = 3;
					cur.c = diffMoveC + 1;
					break;
				case 4:
					diffMoveC = cur.s % sameMoveC;
					if(diffMoveC <= cur.c - 1) { cur.c -= diffMoveC; break; }
					diffMoveC -= cur.c - 1;
					cur.d = 3;
					if(diffMoveC <= C - 1) { cur.c = diffMoveC + 1; break; }
					diffMoveC -= C - 1;
					cur.d = 4;
					cur.c = C - diffMoveC;
					break;
				}//switch end
				shark2[cur.c].add(cur);
			}//for i end
		}//for c end
		
		for (int c = 1; c <= C; c++) {
			Collections.sort(shark2[c]);
		}
		
		for (int c = 1; c <= C; c++) {
			if(shark2[c].isEmpty()) continue;
			for (int i = shark2[c].size() - 1; i > 0; i--) {
				if(shark2[c].get(i).r == shark2[c].get(i-1).r) shark2[c].remove(i);
			}
		}
		
		for (int c = 1; c <= C; c++) {
			shark[c].clear();
			shark[c] = shark2[c];
		}	
	}
}