package com.ssafy.bj_2839;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Bj 2839.설탕 배달
// 11508 kb
// 72 ms
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// N = 4, 7만 -1
		if( N == 4 || N == 7) {
			System.out.println(-1);
			return;
		}
		
		if (N % 5 == 1 || N % 5 == 3) {			// 나머지가 홀수인 경우
			System.out.println((N / 5) + 1);
		} else if (N % 5 == 2 || N % 5 == 4) {	// 나머지가 짝수인 경우
			System.out.println((N / 5) + 2);
		} else { 								// 나눠떨어지는 경우
			System.out.println(N / 5);
		}
	}
}