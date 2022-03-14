//import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(bf.readLine());
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		System.out.println(factorial(N));
		
		sc.close();
		
	}

	private static int factorial(int N) {
		
//		if(N == 1) return N;
//		else return N * factorial(N-1);
//		// 런타임 에러 발생 : N = 0 일 경우를 고려 X
		
		if(N == 0) return 1;
		else return N * factorial(N-1);
		
	}
}
