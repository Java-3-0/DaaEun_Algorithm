import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	static String[] node;
	public static void main(String[] args) throws Exception {
	
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			
			int cnt = Integer.parseInt(br.readLine());
			boolean isChecked = true;
			
			for (int i = 0; i < cnt; i++) {
				node = br.readLine().split(" ");
				
				switch (node[1]) {
				case "+": case "-": case "*": case "/":	// 연산자일 경우
					if(node.length != 4) isChecked = false;
					break;
				default:								// 숫자일 경우
					if(node.length != 2) isChecked = false;
					break;
				}
			}
			sb.append("#" + tc + " " + (isChecked ? 1 : 0) + "\n");
		} // for(tc)-end
		System.out.println(sb.toString());
	}	
}