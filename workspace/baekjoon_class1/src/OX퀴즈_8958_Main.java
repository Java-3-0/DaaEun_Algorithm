import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OX퀴즈_8958_Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < TC; tc++) {
			
			char[] grade = br.readLine().toCharArray();
			
			int answer = 0;
			int score = 1;
			for (int i = 0; i < grade.length; i++) {
				if(grade[i] == 'O') answer += score++;
				else score = 1;
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}
