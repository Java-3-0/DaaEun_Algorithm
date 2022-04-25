import java.util.Scanner;

// 12896 kb
// 112 ms
public class 돌게임_9655_Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if(N % 2 == 0) System.out.println("CY");
		else System.out.println("SK");
		
		sc.close();
	}
}