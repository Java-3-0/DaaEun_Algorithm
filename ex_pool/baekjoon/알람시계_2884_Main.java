import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알람시계_2884_Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		if(45 <= M && M <= 59) System.out.println(H + " " + (M-45));
		else {
			if(H != 0) System.out.println((H-1) + " " + (M+15));
			else System.out.println(23 + " " + (M+15));
		}
	}
}
