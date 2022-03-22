import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

// 62624 kb
// 588 ms
public class 친구네트워크_4195_Main3 {
	
	static int F;
	static int[] parents;
	
	// 단위집합 생성
	public static void makeSet() {
		parents = new int[F*2];
		Arrays.fill(parents, -1);
	}
	
	// a의 집합 찾기 : a의 대표자 찾기
	public static int findSet(int a) {
		if(parents[a] < 0)	return a;
		return parents[a] = findSet(parents[a]);
	}
	
	// a,b 두 집합 합치기
	public static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return;
		
		parents[aRoot] += parents[bRoot];	
		parents[bRoot] = aRoot;
	}
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			F = Integer.parseInt(br.readLine());
			
			makeSet();
			
			int idx = 0;
			for (int f = 0; f < F; f++) {
				st = new StringTokenizer(br.readLine(), " ");
				int[] value = new int[2];
				
				for (int i = 0; i < 2; i++) {
					String name = st.nextToken();
					if(map.containsKey(name)) {
						value[i] = findSet(map.get(name));
					}else {
						value[i] = idx;
						map.put(name, idx++);
					}
				}
				union(value[0], value[1]);
				
				sb.append((-1)*parents[value[0]]).append("\n");
			}//for f end
		}//for tc end
		System.out.println(sb.toString());
	}
}
