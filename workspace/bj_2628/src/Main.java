import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// BJ 2628.종이자르기
// 11776 kb
// 76 ms
public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> cutC = new ArrayList<Integer>();
		ArrayList<Integer> cutR = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int direc = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			
			if(direc == 1) {
				cutC.add(size);
			} else {
				cutR.add(size);
			}
		}
		
		int maxC = cutPaper(C, cutC);
		int maxR = cutPaper(R, cutR);
		
		System.out.println(maxC*maxR);
	}
	
	public static int cutPaper(int length, ArrayList<Integer> cut) {
		cut.add(0);
		cut.add(length);
		Collections.sort(cut);
		
//		for (int i = 0; i < cut.size(); i++) {
//			System.out.print(cut.get(i) + " ");
//		}
//		System.out.println();
		
		int maxLength = 0;
		for (int i = 0; i < cut.size()-1; i++) {
			maxLength = Math.max(maxLength, cut.get(i+1)-cut.get(i));
		}
		return maxLength;
	}
}
