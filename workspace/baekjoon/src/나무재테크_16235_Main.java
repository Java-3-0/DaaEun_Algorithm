import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

// kb
// ms
// 시간초과, M개의 데이터보다 한 곳에 나무를 모아서 저장하여 불러오는 게, 더 효율적 ---> 아니였다.. 정렬이랑 리스트 삭제 안해서 그럼
public class 나무재테크_16235_Main {
	
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	static class Tree implements Comparable<Tree>{
		int x, y, age;

		public Tree(int x, int y, int age) {
			super();
			this.x = x;
			this.y = y;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {	// 나이 내림차순 정렬
			return o.age - this.age;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] food = new int[N][N];
		for(int[] f : food) {
			Arrays.fill(f, 5);
		}
		
		int[][] A = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < N; c++) {
				A[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		LinkedList<Tree> tree = new LinkedList<Tree>();
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			tree.add(new Tree(x, y, age));
		}
		
		for (int k = 0; k < K; k++) {
			// 정렬하기
			Collections.sort(tree);
			//봄
			int end = tree.size() - 1;
			LinkedList<Tree> rottedTree  = new LinkedList<Tree>();
			for (int i = end; i >= 0; i--) {
				int x = tree.get(i).x;
				int y = tree.get(i).y;
				int age = tree.get(i).age;
				
				if(food[x][y] < age) {
					rottedTree.add(new Tree(x, y, age));
					tree.remove(i);
					continue;
				}
				food[x][y] -= age;
				tree.get(i).age++;
			}
			
			//여름
			end = rottedTree.size()-1;
			for (int i = end; i >= 0; i--) {
				int x = rottedTree.get(i).x;
				int y = rottedTree.get(i).y;
				int age = rottedTree.get(i).age;
				food[x][y] += age/2;
				rottedTree.remove(i);
			}

			//가을
			end = tree.size();
			for (int i = 0; i < end; i++) {
				int x = tree.get(i).x;
				int y = tree.get(i).y;
				int age = tree.get(i).age;

				if(age % 5 == 0) {
					for (int d = 0; d < 8; d++) {
						int nr = x + dr[d];
						int nc = y + dc[d];
						
						if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
						tree.add(new Tree(nr, nc, 1));
					}
				}
			}

			//겨울
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					food[r][c] += A[r][c];
				}
			}
		}// for k end
		
		System.out.println(tree.size());
	}
}
