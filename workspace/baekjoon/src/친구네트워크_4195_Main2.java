import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class 친구네트워크_4195_Main2 {
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < TC; tc++) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			int F = Integer.parseInt(br.readLine());
			int[] friendCnt = new int[F];
			int idx = 0;
			for (int f = 0; f < F; f++) {
				st = new StringTokenizer(br.readLine(), " ");
				String name1 = st.nextToken();
				String name2 = st.nextToken();
				// 첫번째 친구 네트워크 
				if(map.containsKey(name1)) {
					idx = map.get(name1);
				}else {
					map.put(name1, idx);
					friendCnt[idx]++;
				}
				// 두번재 친구 네트워크
				if(map.containsKey(name2)) {
					int tmp = map.get(name2);
					for (String name : map.keySet()) {
						if(tmp == map.get(name)) {
							friendCnt[tmp]--;
							map.put(name, idx);
							friendCnt[idx]++;
						}
					}
				} else {
					map.put(name2, idx);
					friendCnt[idx]++;
				}
				sb.append(friendCnt[idx]).append("\n");
				idx++;
			}//for f end
		}//for tc end
		System.out.println(sb.toString());
	}
}
