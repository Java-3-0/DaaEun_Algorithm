import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			int[] week = new int[7];	// 각 요일에 수업 열리는 여부
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 7; i++) {
				week[i] = Integer.parseInt(st.nextToken()); 
			}
			
			int min = Integer.MAX_VALUE;
			for (int start = 0; start < 7; start++) {
				//수업이 시작하는 모든 요일 처리
				if(week[start] == 0) continue;	//수업이 열리지 않는 날은 패스
				
				int day = start, cnt = 0;
				while(true) {
					if(week[day % 7] == 1) cnt++;	//수업이 열리면 카운팅
					++day;	//하루 지남
					if(cnt == n) {	//머무른 최소일수
						min = Math.min(min, day-start);
						break;
					}
				}
			}
			sb.append("#" + tc + " " + min + "\n");
		} //end TC
		System.out.println(sb.toString());
	} //end main
}