import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 48456 kb
// 368 ms
// YES -> 집합의 크기 
public class 집합의표현_1717_Main2 {
	
	static int N;
	static int[] parents;
	
	public static void makeSet() {
		parents = new int[N+1];
		Arrays.fill(parents, -1);
	}
	
	public static int findSet(int a) {
		if(parents[a] < 0) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	public static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return;
		
		parents[aRoot] += parents[bRoot];
		parents[bRoot] = aRoot;
	}
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		makeSet();
		int M = Integer.parseInt(st.nextToken());
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int oper = Integer.parseInt(st.nextToken());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			if(oper == 0) {
				union(num1, num2);
			} else {
				if(findSet(num1) == findSet(num2)) sb.append((-1)*parents[findSet(num1)] + "\n");
				else sb.append("NO\n");
				System.out.println("num1 : " + num1 + ", " + Arrays.toString(parents));
			}
		}//for m end
		System.out.println(sb.toString());
	}
}
