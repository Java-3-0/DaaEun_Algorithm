import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 322524 kb
// 1524 ms
public class 나무재테크_16235_Main2 {
	
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	static class Tree implements Comparable<Tree>{
		int age;

		public Tree(int age) {
			super();
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int N2 = N*N;
		
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
		
		ArrayList<Tree>[] tree = new ArrayList[N2];
		for (int i = 0; i < N2; i++) {
			tree[i] = new ArrayList<Tree>();
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			tree[x*N + y].add(new Tree(age));
		}
		
		ArrayList<Tree>[] rottedTree = new ArrayList[N2];
		for (int i = 0; i < N2; i++) {
			rottedTree[i] = new ArrayList<Tree>();
		}
		for (int k = 0; k < K; k++) {
			
			for (int i = 0; i < N2; i++) {
				Collections.sort(tree[i]);
			}
			
			//봄
			for (int i = 0; i < N2; i++) {
				if(tree[i].size() == 0) continue;
				
				int x = i/N;
				int y = i%N;
				int treeSize = tree[i].size() - 1;
				int end = tree[i].size();
				for (int j = 0; j <= treeSize; j++) {
					int age = tree[i].get(j).age;
					
					if(food[x][y] < age) {
						end = j;
						break;
					}
					food[x][y] -= age;
					tree[i].get(j).age++;
				}
				
				for (int j = treeSize; j >= end; j--) {
					rottedTree[i].add(new Tree(tree[i].get(j).age));
					tree[i].remove(j);
				}
			}

			//여름
			for (int i = 0; i < N2; i++) {
				if(rottedTree[i].size() == 0) continue;
				int x = i/N;
				int y = i%N;
				int rottedTreeSize = rottedTree[i].size() - 1;
				for (int j = rottedTreeSize; j >= 0; j--) {
					int age = rottedTree[i].get(j).age;
					food[x][y] += age/2;
					rottedTree[i].remove(j);
				}
			}

			//가을
			for (int i = 0; i < N2; i++) {
				if(tree[i].size() == 0) continue;
				int x = i/N;
				int y = i%N;
				for (int j = 0; j < tree[i].size(); j++) {
					int age = tree[i].get(j).age;
					
					if(age % 5 == 0) {
						for (int d = 0; d < 8; d++) {
							int nr = x + dr[d];
							int nc = y + dc[d];
							
							if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
							tree[nr*N + nc].add(new Tree(1));
						}
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
		
		int answer = 0;
		for (int i = 0; i < N2; i++) {
			if(tree[i].size() == 0) continue;
			answer += tree[i].size();
		}
		System.out.println(answer);
	}
}
