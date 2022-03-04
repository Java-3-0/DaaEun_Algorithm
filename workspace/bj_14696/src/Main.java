import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

// BJ 14969.딱지놀이
// 29904 kb
// 392 ms
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < TC; tc++) {
			ArrayList<Integer> aCard = new ArrayList<Integer>();
			ArrayList<Integer> bCard = new ArrayList<Integer>();
			
			// A 어린이 카드 정보
			st = new StringTokenizer(br.readLine(), " ");
			int aCnt = Integer.parseInt(st.nextToken());
			for (int i = 0; i < aCnt; i++) {
				aCard.add(Integer.parseInt(st.nextToken()));
			}
			// B 어린이 카드 정보
			st = new StringTokenizer(br.readLine(), " ");
			int bCnt = Integer.parseInt(st.nextToken());
			for (int i = 0; i < bCnt; i++) {
				bCard.add(Integer.parseInt(st.nextToken()));
			}
			
			Collections.sort(aCard, Comparator.reverseOrder());
			Collections.sort(bCard, Comparator.reverseOrder());
			
			int maxCnt = Math.max(aCnt, bCnt);
			String result = "D";
			for (int i = 0; i < maxCnt; i++) {
				
				if(i >= bCnt && i < aCnt) {
					result = "A";
					break;
				}
				if(i >= aCnt && i < bCnt) {
					result = "B";
					break;
				}
				
				if(i < aCnt && i < bCnt) {
					if(aCard.get(i) > bCard.get(i)) {
						result = "A";
						break;
					} else if(aCard.get(i) < bCard.get(i)) {
						result = "B";
						break;
					}
				} else {
					break;
				}
			} //for tc end
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
}
