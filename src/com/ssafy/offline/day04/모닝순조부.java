package com.ssafy.offline.day04;

import java.util.Scanner;

public class 모닝순조부 {
	static int N, R;
	static int[] numbers, input;
	static boolean[] selected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		numbers = new int[R];
		input = new int[N];
		selected = new boolean[N];

		for (int i = 0; i < N; i++)
			input[i] = sc.nextInt();

//		System.out.println("순열");
//		perm(0);
//		System.out.println("조합");
//		comb(0, 0);
//		System.out.println("부분집합 - 재귀");
//		subset(0);
		System.out.println("부분집합 - 비트");
		sebset();
	}

	private static void sebset() {
		for (int i = 0; i < (1 << N); i++) {
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) == 0) continue;
				System.out.print(input[j] + " ");
			}
			System.out.println();
		}
	}

	private static void subset(int cnt) {
		if (cnt == N) {
			for (int i = 0; i <N; i++) {
				if (!selected[i]) continue;
				
				System.out.print(input[i] + " ");
			}
			System.out.println();
			return;
		}
		selected[cnt] = true;
		subset(cnt+1);
		selected[cnt] = false;
		subset(cnt+1);
	}

	private static void comb(int i, int j) {
		// TODO Auto-generated method stub
		
	}

	private static void perm(int i) {
		// TODO Auto-generated method stub
		
	}
	
}
