import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 48456 kb
// 368 ms
public class 집합의표현_1717_Main {
	
	static int N;
	static int[] parents;
	
	public static void makeSet() {
		parents = new int[N+1];
		for (int i = 0; i < N+1; i++) {
			parents[i] = i;
		}
	}
	
	public static int findSet(int a) {
		if(a == parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	public static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return;
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
				if(findSet(num1) == findSet(num2)) sb.append("YES\n");
				else sb.append("NO\n");
			}
		}//for m end
		System.out.println(sb.toString());
	}
}
