package com.ssafy.bj_2493;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main5 {

	public static void main(String[] args) throws Exception {
		
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Queue <int[]> top = new LinkedList<int[]>();	// top 스택 : {탑순서, 탑높이} 배열
		Stack<int[]> stop = new Stack<int[]>();
		int[] answer = new int[N];
		for (int i = 0; i < N; i++) {
			top.offer(new int[]{i, Integer.parseInt(st.nextToken())});
		}

		answer[0] = 0;
		stop.push(top.poll());
		// 알고리즘 구현
		while(true) {
			if(top.isEmpty()) break;	
			
			int[] tmp = top.peek();
			if(stop.isEmpty()) {
				answer[tmp[0]] = 0;
				top.poll();
				stop.push(tmp);
			} else if(stop.peek()[1] > tmp[1]) {
				answer[tmp[0]] = stop.peek()[0]+1;
				top.poll();
				stop.push(tmp);
			} else {
				stop.pop();
			}
		}
		
		for(int a : answer) {
			sb.append(a + " ");
		}
		System.out.println(sb.toString());
	}
}