import java.util.Scanner;

// 12892 kb
// 112 ms
public class 돌게임6_9660_Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		
		if(N % 7 == 0 || N % 7 == 2) System.out.println("CY");
		else System.out.println("SK");
		
		sc.close();
	}
}