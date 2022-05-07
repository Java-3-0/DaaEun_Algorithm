import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 음계_2920_Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] scale = new int[8];
		for (int i = 0; i < 8; i++) {
			scale[i] = Integer.parseInt(st.nextToken());
		}
		
		int change = 0;
		if(scale[0] == 1) change = 1;
		else if(scale[0] == 8) change = -1;
		else {
			System.out.println("mixed");
			return;
		}
		
		for (int i = 1; i < 8; i++) {
			if(scale[i] == scale[i-1]+change) continue;
			else {
				System.out.println("mixed");
				return;
			}
		}
		
		if(change == 1) System.out.println("ascending");
		else System.out.println("decscending");
	}
}
