import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11536 kb
// 76 ms
public class 직사각형에서탈출_1085_Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int shortW = x < w-x ? x : w-x;
		int shortH = y < h-y ? y : h-y;
		
		System.out.println(shortW<shortH?shortW:shortH);
	}
}
