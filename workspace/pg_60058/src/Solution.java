import java.util.LinkedList;
import java.util.Stack;


public class Solution {
	
	static StringBuilder sb = new StringBuilder();
	
	public String solution(String p) throws Exception {
		char[] str = p.toCharArray();
		LinkedList<Character> test = new LinkedList<Character>();
		for (int i = 0; i < str.length; i++) {
			test.add(str[i]);
		}
		divideBracket(test);
		return sb.toString();
	}
	
	public static void divideBracket(LinkedList<Character> p) {
		
		if(p.isEmpty()) return;
		
		int leftCnt = 0;
		int rightCnt = 0;
		LinkedList<Character> u = new LinkedList<Character>();
		LinkedList<Character> v = new LinkedList<Character>();
		int stop = 0;
		for (int i = 0; i < p.size(); i++) {
			if(p.get(i) == '(') leftCnt++;
			else rightCnt++;
			
			u.add(p.get(i));
			
			if(leftCnt == rightCnt) {
				stop = i+1;
				break;
			}
		}
		for (int j = stop; j < p.size(); j++) {
			v.add(p.get(j));
		}
		
		if(isCorrected (u)) {
			for(Character ch : u) {
				sb.append(ch);
			}
			divideBracket(v);
		} else {
			divideBracket(makeCorrectBracket(u, v)); 
		}
	}
	
	public static LinkedList<Character> makeCorrectBracket(LinkedList<Character> u, LinkedList<Character> v) {
		LinkedList<Character> temp = new LinkedList<Character>();
		temp.add('(');
		// 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
		for (int i = 0; i < v.size(); i++) {
			temp.add(v.get(i));
		}
		temp.add(')');
		
		for (int i = 1; i < u.size()-1; i++) {
			if(u.get(i) == '(') {
				temp.add(')');
			} else {
				temp.add('(');
			}
		}
		return temp;
	}

	public static boolean isCorrected(LinkedList<Character> u) {
	
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < u.size(); i++) {
			if(u.get(i) == '(') {
				stack.push(u.get(i));
			} else {
				if(stack.isEmpty()) return false;
				else stack.pop();
			}
		}
		return true;
	}	
}
