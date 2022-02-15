

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 수행시간 : 88 ms
// 메모리 소비량 : 16228 kb
public class Main {

	static String[] talk = {"어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n",
					"\"재귀함수가 뭔가요?\"\n",
					"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n",
					"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n",
					"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n",
					"\"재귀함수는 자기 자신을 호출하는 함수라네\"\n",
					"라고 답변하였지.\n"
					};
	
	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());

		System.out.print(talk[0]);
		System.out.print(startRecurFunc(n));
		System.out.print(midFunc(n));
		System.out.print(endRecurFunc(n));
	}


	//startRecurFunc(n)
	private static String startRecurFunc(int n) {
		
		if (n == 0) return "";

		StringBuffer bf = new StringBuffer();
		bf.append(startRecurFunc(n - 1));
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < n; j++) {
				bf.append("____");
			}
			bf.append(talk[i]);
		}
		return bf.toString();
	}
	
	//midFunc(n)
	private static String midFunc(int n) {
		
		StringBuffer bf = new StringBuffer();
		for (int i = 1; i < 6; i += 4) {
			for (int j = 0; j < n; j++) {
				bf.append("____");
			}
			bf.append(talk[i]);
		}
		return bf.toString();
	}
	
	//endRecurFunc(n)
	private static String endRecurFunc(int n) {
		
		if (n < 0) return "";

		StringBuffer bf = new StringBuffer();
		for (int j = 0; j < n; j++) {
			bf.append("____");
		}
		bf.append(talk[6]);
		bf.append(endRecurFunc(n - 1));
		
		return bf.toString();
	}
}
