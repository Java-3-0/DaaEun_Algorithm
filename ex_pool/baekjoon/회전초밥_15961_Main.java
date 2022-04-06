import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 20824 kb
// 236 ms
public class Main_2531_회전초밥_양다은 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 회전초밥 벨트에 놓인 접시의 수
		int d = Integer.parseInt(st.nextToken());	// 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken());	// 연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken());	// 쿠폰 번호
		
		ArrayList<Integer> sushi = new ArrayList<Integer>();
		for (int n = 0; n < N; n++) {
			sushi.add(Integer.parseInt(br.readLine()));
		}
		for (int i = 0; i < k; i++) {
			sushi.add(sushi.get(i));
		}

		// 선언
		Map<Integer, Integer> map = new HashMap<>();
		// 초기화
		for (int i = 0; i < k; i++) {
			int tmp = sushi.get(i);
			if(map.containsKey(tmp)) {
				map.put(tmp, map.get(tmp)+1);
			}else {
				map.put(tmp, 1);
			}
		}
		int cnt = map.size();
		boolean useCoupon = map.containsKey(c)? false : true;
		int maxCnt = cnt + (useCoupon? 1 : 0);
		
		for (int i = 0; i < N; i++) {
			int preP = i;
			int nextP = i+k;
			int preSushi = sushi.get(preP);
			int nextSushi = sushi.get(nextP);
			
			if(map.get(preSushi) == 1) {
				map.remove(preSushi);
			}else {
				map.put(preSushi, map.get(preSushi)-1);
			}
			
			if(map.containsKey(nextSushi)) {
				map.put(nextSushi, map.get(nextSushi)+1);
			}else {
				map.put(nextSushi, 1);
			}
			
			cnt = map.size();
			useCoupon = map.containsKey(c)? false : true;
			maxCnt = Math.max(maxCnt, cnt + (useCoupon? 1 : 0));
			if(maxCnt == k+1) break;
		}
		System.out.println(maxCnt);
	}
}
