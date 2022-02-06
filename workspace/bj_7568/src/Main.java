import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

/* 덩치 */
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		StringTokenizer st = null;
		int[][] kgCm = new int[N][2];
		int[] bodyRank = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			kgCm[i][0] = Integer.parseInt(st.nextToken()); // 몸무게
			kgCm[i][1] = Integer.parseInt(st.nextToken()); // 키
		}

		List<Integer> kgs = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			kgs.add(kgCm[i][0]);
		}

		// 중복제거 및 오름차순 정렬
		HashSet<Integer> kgsSort = new HashSet<Integer>(kgs);
		kgs = new ArrayList<Integer>(kgsSort);

		// 몸무게를 기준으로 등수 결정
		for (int j = 0; j < kgs.size(); j++) {
			for (int i = 0; i < N; i++) {
				if (kgs.get(j) == kgCm[i][0]) bodyRank[i] = j + 1;
			}
		}

		// 몸무게 등수를 기준으로 키 비교하면서 최종 덩치등수 결정
		for (int i = 1; i < N; i++) {
			for(int j=0; j<N; j++) {
				if(bodyRank[j] == i) {
//					int tmpCm = kgCm[j][1];
				}
				//@@@@@@@@@ 머릿속 멘붕...
				
			}
		}
	}
}
