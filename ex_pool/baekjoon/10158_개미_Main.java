import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BJ 10158.개미
// 11536 kb
// 88 ms
public class Main {

	static int w, h, x, y, t;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(br.readLine());
		
		System.out.println(getPos(x, w) + " " + getPos(y, h));
	}

	public static int getPos(int startx, int unit) {
		int endX = (startx + t) % unit; 
		if(((startx + t)/unit)%2 != 0) {
			endX = unit - endX;
		}
		return endX;
	}
}
