import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 208148 kb
// 964 ms
public class 과제는끝나지않아_17952_Main {
	
	static class homework{
		int grade, time, doing;

		public homework(int grade, int time, int doing) {
			super();
			this.grade = grade;
			this.time = time;
			this.doing = doing;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		int totalGrade = 0;
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<homework> stack = new Stack<homework>();
		int curGrade = 0;
		int curTime = 0;
		int curDoing = 0;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			int hw = Integer.parseInt(st.nextToken());
			if(hw == 0) {	// 과제가 주어지지 않은 경우
				curDoing++;
			} else {	// 과제가 주어진 경우
				if(curGrade != 0) {	// 하던 과제가 있는 경우
					stack.push(new homework(curGrade, curTime, curDoing));
				}
				curGrade = Integer.parseInt(st.nextToken());
				curTime = Integer.parseInt(st.nextToken());
				curDoing = 1;
			}
			
//			System.out.println("n : "+n+", curGrade : " + curGrade+ ", curTime : " + curTime + ", curDoing : " + curDoing);
			// 과제를  끝냈는지 아닌지 확인
			if(curDoing == curTime) {
				totalGrade += curGrade;
				if(stack.isEmpty()) {
					curGrade = 0;
					curTime = 0;
					curDoing = 0;
				} else {
					homework h = stack.pop();
					curGrade = h.grade;
					curTime = h.time;
					curDoing = h.doing;
				}
			}
		}
		System.out.println(totalGrade);
	}
}
