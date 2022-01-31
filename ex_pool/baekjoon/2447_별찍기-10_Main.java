import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		starFunc(N);

		sc.close();
	}

	private static void starFunc(int N) {

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (r / 3 == 1 & c / 3 == 1) {
					System.out.print(" ");
					continue;
				}

				if (r % 3 == 1 & c % 3 == 1) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	// N=9 일때를 기준으로 9등분하여 접근해봄.
	// 재귀가 아닌 단순 반복문으로는 구현해볼 수 있으나 재귀는 모르겠음.
	// 그런데 N=27일때는 또 안되넹XD
}
