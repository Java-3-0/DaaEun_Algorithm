import java.util.Scanner;

/* 분해합  */
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		System.out.println(consFunc(N));
		
		sc.close();
	}

	private static int consFunc(int N) {
		int num = 1;
		while (num < N) {
			String strNum = Integer.toString(num);
			char[] numUnit = strNum.toCharArray();

			int tmp = num;
			for (char unit : numUnit) {
				tmp += unit - '0';
			}

			if (tmp == N) return num;

			num++;
		}
		return 0;
	}
}