import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
class Solution {
    public String solution(String p) {
        String answer = "";
        return answer;
    }
}
 */

public class Solution {
	
	static LinkedList<Character> p = new LinkedList<Character>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		for (int i = 0; i < str.length; i++) {
			p.add(str[i]);
		}
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
			divideBracket(v);
		} else {
			makeCorrectBracket(u, v); // <-이거 구현부터 시작
		}
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
