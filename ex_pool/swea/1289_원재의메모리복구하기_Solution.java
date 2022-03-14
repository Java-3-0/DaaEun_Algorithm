import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {

		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {

			int answer = 0;
			String num = bf.readLine();

			if (num.charAt(0) == '1') {
				answer++;
			}
			
			for (int i = 1; i < num.length(); i++) {
				if (num.charAt(i - 1) == '0' && num.charAt(i) == '1') {
					answer++;
				} else if (num.charAt(i - 1) == '1' && num.charAt(i) == '0') {
					answer++;
				}
			} // for(i)-end
			sb.append("#" + tc + " " + answer + "\n");
		} // for(tc)-end
		System.out.println(sb.toString());
	}
}