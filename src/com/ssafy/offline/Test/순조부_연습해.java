package com.ssafy.offline.Test;

import java.util.Arrays;
import java.util.Scanner;

public class 순조부_연습해 {
	static int N, R;
	static int[] input, number;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		number = new int[R];
		visit = new boolean[N];
		for (int i = 0; i < N; i++) {
			input[i] = i+1;
		}
		//System.out.println(Arrays.toString(number));
		//System.out.println(Arrays.toString(input));
		
		System.out.println("순열");
		perm(0,0);
		System.out.println("조합");

		System.out.println("부분집합 - 재귀");

		System.out.println("부분집합 - 비트");

		System.out.println("순열 - 비트");
	}
	private static void perm(int cnt) {
//	private static void perm(int idx, int cnt) {
//		if (cnt == R) {
//			System.out.println(Arrays.toString(number));
//			return;
//		}
//		if (idx >= N) return;
//		
//		else number[cnt] = input[idx];
//		
//		perm(idx+1, cnt+1);
//		perm(idx+1, cnt);
		
		if (cnt == R) {
			System.out.println(Arrays.toString(number));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visit[i]) continue;
			visit[i] = true;
			number[cnt] = input[i];
			perm(cnt+1);
			visit[i] = false;
		}
	}
}
