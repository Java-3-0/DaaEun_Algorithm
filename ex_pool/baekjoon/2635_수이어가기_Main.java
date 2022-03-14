import java.util.ArrayList;
import java.util.Scanner;

// BJ 2635.수 이어가기
// 15588 kb
// 132 ms
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int max = 0;
		ArrayList<Integer> answer = new ArrayList<Integer>();
		for (int i = N/2; i <= N; i++) {
			ArrayList<Integer> arr = new ArrayList<Integer>();
			arr.add(N);
			int temp = i;
			while(true) {
//				for(Integer a : arr) {
//					System.out.print(a + " ");
//				}
//				System.out.println();
				if(temp < 0) break;
				arr.add(temp);
				temp = arr.get(arr.size()-2) - temp;
			}
			if(max < arr.size()) {
				answer = arr;
				max = arr.size();
			}
		}
		System.out.println(max);
		for(Integer ans : answer) {
			System.out.print(ans + " ");
		}
		sc.close();
	}
}
