import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
// 시간부족으로 주석못했어요 ㅠㅠ
// 3. 전산실이 위험하다
public class Main {
	
	static int N;	// 관리자 패스워드의 최댓값을 나타내는 정수
	static int M; 	// 해커가 사용한 패스워드의 개수를 나타내는 정수
	static byte[] p;	// 해커가 사용한 패스워드 배열
	static int int1;	// 보안척도
	static int int2 = 10;	// 보안성
	
	public static void main(String[] args) throws Exception {
		// 입력을 위한 BufferedReader 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 관리자 패스워드의 최댓값을 나타내는 수 입력받기
		N = Integer.parseInt(br.readLine()); 
		// 해커가 사용한 패스워드의 개수를 나타내는 수 입력받기
		M = Integer.parseInt(br.readLine()); 
		// 해커가 사용한 패스워드 배열 초기화
		p = new byte[M];
		// StringTokenizer 선언 및 line 읽기
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 패스워드 입력받기
		for (int i = 0; i < M; i++) {
			p[i] = Byte.parseByte(st.nextToken());
		}
		fuction(1);
		System.out.println(int2);
	}

	private static void fuction(int i) {
		if(i == M) return;
		int tmp = p[i-1]^p[i];
		int1 = 0;
		while(tmp > 0) {
			if(tmp%2 == 1) {
				int1++;
				System.out.println(int1);
			}
			tmp = tmp/2;
		}
		int2 = int1 < int2? int1: int2;
		fuction(++i);
	}
	
}
