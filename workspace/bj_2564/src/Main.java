import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BJ 2564.경비원
// 11576 kb
// 76 ms
public class Main {
	
	static int width, height, shopCnt, answer;
	static int[][] shop, guardman = new int[1][3];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		shopCnt = Integer.parseInt(br.readLine());
		shop = new int[shopCnt][3];
		
		for (int i = 0; i < shopCnt; i++) {
			isLocated(new StringTokenizer(br.readLine(), " "), i, shop);
		}
		isLocated(new StringTokenizer(br.readLine(), " "), 0, guardman);
		
		Guard();
		System.out.println(answer);
	}

	private static void isLocated(StringTokenizer st, int n, int[][] arr) {
		switch (st.nextToken()) {
		case "1":
			arr[n] = new int[] {1, 0, Integer.parseInt(st.nextToken())};
			break;
		case "2":
			arr[n] = new int[] {2, height, Integer.parseInt(st.nextToken())};
			break;
		case "3":
			arr[n] = new int[] {3, Integer.parseInt(st.nextToken()), 0};
			break;
		case "4":
			arr[n] = new int[] {4, Integer.parseInt(st.nextToken()), width};
			break;
		}
		
	}
	
	private static void Guard() {
		if(guardman[0][0] == 1 || guardman[0][0] == 2) {
			for (int i = 0; i < shopCnt; i++) {
				if(guardman[0][1] == shop[i][1]) {
					answer += Math.abs(guardman[0][2] - shop[i][2]);
				} else if(shop[i][2] == 0 || shop[i][2] == width) {
					answer += Math.abs(guardman[0][1] - shop[i][1]) + Math.abs(guardman[0][2] - shop[i][2]);
				} else {
					answer += height + Math.min(guardman[0][2] + shop[i][2], (width-guardman[0][2]) + (width-shop[i][2]));
				}
			}
		} else if(guardman[0][0] == 3 || guardman[0][0] == 4) {
			for (int i = 0; i < shopCnt; i++) {
				if(guardman[0][2] == shop[i][2]) {
					answer += Math.abs(guardman[0][1] - shop[i][1]);
				} else if(shop[i][1] == 0 || shop[i][1] == height) {
					answer += Math.abs(guardman[0][1] - shop[i][1]) + Math.abs(guardman[0][2] - shop[i][2]);
				} else {
					answer += width + Math.min(guardman[0][1] + shop[i][1], (width-guardman[0][1]) + (width-shop[i][1]));
				}
			}
		}
	}	
}
