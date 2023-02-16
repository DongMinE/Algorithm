package com.ssafy.live.day09;

import java.util.Arrays;
import java.util.Scanner;

public class Permutation {
	static int N, R;
	static int[] numbers, inputs;
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();

		numbers = new int[R];
		inputs = new int[N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			inputs[i] = sc.nextInt();

		}
		gererateSubSet(0, 0);
	}

	private static void gererateSubSet(int cnt, int flag) {

		if (cnt == R) {
			System.out.print(Arrays.toString(numbers));
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((flag & (1 << i)) != 0) continue;
			numbers[cnt] = inputs[i];
			isSelected[cnt] = true;
			gererateSubSet(cnt + 1, flag | (1<<i));

		}
	}

}
