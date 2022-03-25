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
		// 1. 25C7
		// 2. BFS
		// 3.
		// (x,y) -> 하나의 번호
		// 4. 7명중 4명이 이다솜파
		// 조합 -> 4명이상 -> BFS -> cnt++
		// 가지치기 : 조합중 4개의상의 Y
		// (x,y) -> 하나의 번호
	}
}
