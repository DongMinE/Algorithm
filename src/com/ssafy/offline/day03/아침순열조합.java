package com.ssafy.offline.day03;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class 아침순열조합 {
	static int N, R;
	static int[] inputs, numbers;
	static boolean[] visited;
	static int cunt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		inputs = new int[N];
		numbers = new int[R];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			inputs[i] = sc.nextInt();
		}
		cunt = 0;
		System.out.println("순열");
		perm(0);
		System.out.println(cunt);

		cunt = 0;
		System.out.println("조합");
		comb(0, 0);
		System.out.println(cunt);
	}
	//순열
	private static void perm(int cnt) {
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			numbers[cnt] = inputs[i];
			perm(cnt + 1);
			visited[i] = false;
		}
	}
	//조합
	private static void comb(int cnt, int start) {
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = start; i < N; i++) {
			numbers[cnt] = inputs[i];
			comb(cnt + 1, i + 1);
		}
	}
}
