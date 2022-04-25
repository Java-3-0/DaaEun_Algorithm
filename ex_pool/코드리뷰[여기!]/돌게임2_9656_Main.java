import java.util.Scanner;

// 12888 kb
// 116 ms
public class 돌게임2_9656_Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if(N % 2 == 0) System.out.println("SK");
		else System.out.println("CY");
		
		sc.close();
	}
}