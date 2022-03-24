import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// kb
// ms
public class 소문난칠공주_1941_Main {
	
	static char[][] classroom = new char[5][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {
			classroom[i] = br.readLine().toCharArray();
		}
	}
}
