import java.util.Scanner;

// 12880 kb
// 112 ms
public class 돌게임5_9659_Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		
		if(N % 2 == 0) System.out.println("CY");
		else System.out.println("SK");
		
		sc.close();
	}
}