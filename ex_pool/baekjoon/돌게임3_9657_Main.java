import java.util.Scanner;

// 12888kb
// 128 ms
public class 돌게임3_9657_Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if(N % 7 == 0 || N % 7 == 2) System.out.println("CY");
		else System.out.println("SK");
		
		sc.close();
	}
}