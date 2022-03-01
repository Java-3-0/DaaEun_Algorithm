import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
25
0 1 0 1 0 0 0 1 0 1 0 1 0 0 0 1 0 1 0 1 0 0 0 1 1
2
1 3
2 3

5
0 0 1 1 1
1
2 3

5
0 0 0 0 0
1
2 3
 */
// BJ 1244.스위치 켜고 끄기
// 11656 kb
// 80 ms
public class Main {

	static int[] power;

	public static void main(String[] args) throws NumberFormatException, IOException {

		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int powerCnt = Integer.parseInt(br.readLine());

		power = new int[powerCnt];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < powerCnt; i++) {
			power[i] = Integer.parseInt(st.nextToken());
		}
//		sb.append(Arrays.toString(power) + "\n");

		int stuCnt = Integer.parseInt(br.readLine());

		for (int i = 0; i < stuCnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sex = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());

			if (sex == 1) {
				for (int j = number - 1; j < powerCnt; j += number) {
					powerOnOff(j);
				}
//				sb.append(Arrays.toString(power) + "\n");
			} else {
				powerOnOff(number - 1);
				for (int j = 1; j < powerCnt; j++) {
					if (number-1-j >= 0 && number-1+j < powerCnt && power[number - 1 - j] == power[number - 1 + j]) {
						powerOnOff(number - 1 - j);
						powerOnOff(number - 1 + j);
					} else break;
				}
//				sb.append(Arrays.toString(power) + "\n");
			}
		} // for stuCnt end

		for (int i = 0; i < powerCnt; i++) {
			if (i / 20 != 0 && i % 20 == 0) {
				sb.append("\n");
			}
			sb.append(power[i] + " ");
		}
		System.out.println(sb.toString());
	}

	public static void powerOnOff(int current) {
		if (power[current] == 0) {
			power[current] = 1;
		} else {
			power[current] = 0;
		}
	}
}
