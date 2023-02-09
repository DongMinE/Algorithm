package com.ssafy.offline.day04;

import java.util.Arrays;
import java.util.Scanner;

public class 모닝순조부2 {
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

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		System.out.println("조합");
		comb(0,0);
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
	
}
