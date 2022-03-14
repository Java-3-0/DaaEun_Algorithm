import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Bj 2304.창고 다각형
// 12076 kb
// 92 ms
public class Main {

	static class Column implements Comparable<Column>{
		
		public int L;	// 기둥의 왼쪽 면의 위치
		public int H;	// 기둥의 높이
		
		
		public Column(int L, int H) {
			super();
			this.L = L;
			this.H = H;
		}

		// H 기준 내림차순 정렬
		@Override
		public int compareTo(Column o) {
			return o.H - this.H;
		}
	}
	
	static int N, deleteWidth, deleteHight, deletearea, totalRoofArea;
	static int[] totalL = new int[2];
	static PriorityQueue<Column> column = new PriorityQueue<Column>();
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
//		Column[] column = new Column[N]
		// 우선순위 큐에 Column H 기준 내림차순으로 담기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			column.offer(new Column(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
//		Arrays.sort(column);
		// 제대로 입력 및 정렬되었는지 확인
//		for (int i = 0; i < N; i++) {
//			System.out.println( column.peek().L +" " + column.peek().H);
//			column.poll();
//		}
		makeRoof();
		System.out.println(totalRoofArea);
		
	}
	
	public static void makeRoof() {
		
		// 가장 높은 기둥 H, L
		int MaxH = column.peek().H;
		int MaxHofL = column.peek().L;
		column.poll();
		
		// deletearea 계산하기
		while(!column.isEmpty()) {
			int tempH = column.peek().H;
			int tempHofL = column.peek().L;
			column.poll();
			if(tempHofL < MaxHofL) {
				if(totalL[0] == 0) {
					deleteWidth = MaxHofL - tempHofL;
				}
				else if(tempHofL < totalL[0]) {
					deleteWidth = totalL[0] - tempHofL;
				} else continue;
				totalL[0] = tempHofL;
			} else {	// MaxHofL < tempHofL
				if(totalL[1] == 0) {
					deleteWidth = tempHofL - MaxHofL;
				}
				else if(totalL[1] < tempHofL) {
					deleteWidth = tempHofL - totalL[1];
				} else continue;
				totalL[1] = tempHofL;
			}
			deleteHight = MaxH - tempH;
			deletearea += deleteWidth * deleteHight;
		} // while-end
		
		// 가장 높은 기둥이 시작 혹은 끝에 있을 경우
		if(totalL[0] == 0) totalL[0] = MaxHofL;
		if(totalL[1] == 0) totalL[1] = MaxHofL;
		// 최종 창고 다각형 넓이
		totalRoofArea = (Math.abs(totalL[0] - totalL[1]) + 1) * MaxH - deletearea;
	}	
}
