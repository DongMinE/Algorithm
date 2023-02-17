package com.ssafy.offline.Test;

import java.util.Arrays;
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

		System.out.println("순열");
		perm(0);

		System.out.println("조합");
		comb(0, 0);

		System.out.println("부분집합 - 재귀");
		subset(0);

		System.out.println("부분집합 - 비트");
		subset();

		System.out.println("순열 - 비트");
		perm2(0, 0);

		System.out.println("순열-Next");
		nextPerm();

		System.out.println("조합-Next");
		nextComb();
	}

	private static void perm(int cnt) {
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (selected[i]) continue;
			selected[i] = true;
			numbers[cnt] = input[i];
			perm(cnt+1);
			selected[i] = false;
		}
	}

	private static void comb(int cnt, int start) {
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			comb(cnt+1, i+1);
		}
	}

	private static void subset(int cnt) {
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
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

	private static void subset() {
		for (int i = 0; i < (1 << N); i++) {
			for (int j = 0; j <N; j++) {
				if ((i & (1 << j)) == 0 ) continue;
					System.out.print(input[j] + " ");
			}
			System.out.println();
		}
	}

	private static void perm2(int cnt, int flag) {
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 0; i < N; i++) {
			if ((flag & (1 << i)) != 0)
				continue;
			numbers[cnt] = input[i];
			selected[cnt] = true;
			perm2(cnt + 1, flag | (1 << i));
		}
	
	}

	private static void nextPerm() {
		Arrays.sort(input);
		do {
			for (int i = 0; i < N; i++)
				System.out.print(input[i] + " ");
			System.out.println();
		} while (np(null));
	}

	private static void nextComb() {
		numbers = new int[N];
		// 배열 뒤부터 R개수만큼 1로 만듦 : 5C2라면 00011 이런형태로
		int cnt = 0;
		while (++cnt <= R) {
			numbers[N - cnt] = 1;
		}

		do {
			for (int i = 0; i < N; ++i) {
				if (numbers[i] == 1)
					System.out.print(input[i] + " ");
			}
			System.out.println();
		} while (np(numbers));
	}

	private static boolean np(int[] input) {
		if (input == null)
			input = 모닝순조부.input;

		int N = input.length;

		int i = N - 1;
		while (i > 0 && input[i - 1] >= input[i])
			--i;

		if (i == 0)
			return false;

		int j = N - 1;
		while (input[i - 1] >= input[j])
			--j;

		swap(input, i - 1, j);

		int k = N - 1;
		while (i < k)
			swap(input, i++, k--);

		return true;
	}

	private static void swap(int numbers[], int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}