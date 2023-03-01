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
			input[i] = i + 1;
		}
		// System.out.println(Arrays.toString(number));
		// System.out.println(Arrays.toString(input));

		System.out.println("순열");
		perm(0);
		System.out.println("조합");
		comb(0, 0);
		System.out.println("부분집합 - 재귀");
		subset(0);
		System.out.println("부분집합 - 비트");
		subset();
		System.out.println("순열 - 비트");
		perm();
	}


	private static void perm(int cnt) {
		if (cnt == R) {
			System.out.println(Arrays.toString(number));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			number[cnt] = input[i];
			perm(cnt + 1);
			visit[i] = false;
		}
	}

	private static void comb(int cnt, int start) {
		if (cnt == R) {
			System.out.println(Arrays.toString(number));
			return;
		}
		for (int i = start; i < N; i++) {
			number[cnt] = input[i];
			comb(cnt + 1, i + 1);
		}
//		if (cnt == R) {
//			System.out.println(Arrays.toString(number));
//			return;
//		}
//		if (start == N) return;
//		number[cnt] = input[start];
//		comb(cnt+1,start+1);
//		comb(cnt,start+1);
	}

	private static void subset(int cnt) {
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				if (!visit[i]) continue;
				System.out.print(input[i] + " ");
			}
			System.out.println();
			return;
		}
		visit[cnt] = true;
		subset(cnt + 1);
		visit[cnt] = false;
		subset(cnt + 1);
	}
	
	private static void subset() {
		for (int i = 0; i < (1 << N); i++) {
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) == 0) continue;
				System.out.print(input[j]+ " ");
			}
			System.out.println();
		}
	}
	
	private static void perm() {
		
	}
	
}
