package com.ssafy.bj_2961;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BJ 2961.도영이가 만든 맛있는 음식
// 11536 kb
// 72 ms
public class Main {
	
	static int N, cuisine = Integer.MAX_VALUE;
	static int[] p, S, B;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		p = new int[N];
		S = new int[N];
		B = new int[N];
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		generateSubset();
		System.out.println(cuisine);
	}

	private static void generateSubset() {
		for(int flag = 1; flag < (1<<N); flag++) {
			int STotal = 1;
			int BTotal = 0;
			for (int i = 0; i < N; i++) {
				if((flag & 1<<i) != 0) {
					STotal *= S[i];
					BTotal += B[i];
				}
			}
			cuisine = Math.min(cuisine, Math.abs(STotal-BTotal));
		}
	}

}
