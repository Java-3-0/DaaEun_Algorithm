import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input.txt"));
		
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		Scanner sc = new Scanner(System.in);
		sc.close();
	}
}
