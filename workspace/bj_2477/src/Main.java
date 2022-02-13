import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BJ 2477.참외밭
// 11504 kb
// 80 ms
public class Main {
	
	static int kMelon, longlength1, longlength2;
	static int[][] farm = new int[6][2];
	static int[] defense = new int[5];
	static int[] idx = new int[4];
	
	public static void main(String[] args) throws Exception {
		
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		kMelon = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			farm[i][0] = Integer.parseInt(st.nextToken());
			farm[i][1] = Integer.parseInt(st.nextToken());
			defense[farm[i][0]]++;
		}
		
		longlength1 = defense[1] < defense[2]? 1 : 2;
		longlength2 = defense[3] < defense[4]? 3 : 4;
		
		for (int i = 0; i < 6; i++) {
			if(farm[i][0] == longlength1) idx[0] = i;
			else if(farm[i][0] == longlength2) idx[1] = i;
		}
		
		if ((idx[0] == 0 && idx[1] == 5) || (idx[0] == 5 && idx[1] == 0)) {
			System.out.println((farm[0][1] * farm[5][1] - farm[2][1] * farm[3][1]) * kMelon);
		} else {
			double idxAvg = (idx[0] + idx[1]) / 2.0;
			idx[2] = (int) ((idxAvg + 3.5) % 6);
			idx[3] = (int) ((idxAvg + 8.5) % 6);
			System.out.println((farm[idx[0]][1] * farm[idx[1]][1] - farm[idx[2]][1] * farm[idx[3]][1]) * kMelon);
		}
	}
}