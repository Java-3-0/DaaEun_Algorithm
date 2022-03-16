import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 18520 kb
// 352 ms
public class 컨베이어벨트위의로봇_20055_Main {
	
	static int n, k, step;
	
	static ArrayList<Integer> up = new ArrayList<Integer>();
	static ArrayList<Integer> down = new ArrayList<Integer>();
	static ArrayList<Boolean> robot = new ArrayList<Boolean>();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			up.add(Integer.parseInt(st.nextToken()));
			robot.add(false);
		}
		for (int i = 0; i < n; i++) {
			down.add(Integer.parseInt(st.nextToken()));
		}
		Collections.reverse(up);
		Collections.reverse(down);

		int zeroCnt = 0;
		int step = 0;
		while(true) {
			step++;
			// 1.벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
			robot.remove(0);
			robot.add(false);
			down.add(up.remove(0));
			up.add(down.remove(0));

			// 2.가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
			if(robot.get(0) == true) robot.set(0, false);
			for (int i = 1; i < n; i++) {
				if(robot.get(i) == true && robot.get(i-1) == false && up.get(i-1) != 0) {	//로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
					robot.set(i-1, true);
					robot.set(i, false);
					int change = up.get(i-1)-1;
					up.set(i-1, change);
					if(change == 0) zeroCnt++;
				}
			}
			
			// 3.올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
			if(up.get(n-1) != 0) {
				robot.set(n-1, true);
				int change = up.get(n-1)-1;
				up.set(n-1, change);
				if(change == 0) zeroCnt++;
			}
//			System.out.println("step : " + step);
//			System.out.println(up.toString());
//			System.out.println(down.toString());
			
			// 4.내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다
			if(zeroCnt >= k) break;
		}// while end
		System.out.println(step);
	}
	
}
