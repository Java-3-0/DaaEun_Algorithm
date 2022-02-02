import java.util.Scanner;

/* 하노이 탑 이동 순서  */
public class Main {

	public static StringBuilder sb = new StringBuilder();
	// 시간초과 에러 방지
	// sysout보다 효율적

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		// 하노이탑 옮긴 횟수
		sb.append((int) (Math.pow(2, N) - 1)).append('\n');

		// 하노이탑 수행 과정
		hanoiFunc(N, 1, 2, 3);

		// 결과 출력
		System.out.println(sb);

		sc.close();
	}

	private static void hanoiFunc(int N, int start, int temp, int end) {

		if (N == 1) {
			sb.append(start + " " + end + "\n");
			return;
		}

		hanoiFunc(N - 1, start, end, temp);		// N-1개를 1->2
		sb.append(start + " " + end + "\n");	// 제일 큰 원판을 1->3
		hanoiFunc(N - 1, temp, start, end);		// N-1개를 2->3
	}
}
