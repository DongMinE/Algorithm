package com.ssafy.ws.BOJ.Silver;

import java.util.Scanner;

public class S1_1074_Z {
	static int N, R, C, count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();
		count = 0;
		recursive(R, C, (int) Math.pow(2, N));
		System.out.println(count);
	}

	private static void recursive(int r, int c, int size) {
		// 못쪼
		if (size == 1) {
			return;
		}

		int half = size / 2;
		// 1분면
		if (r < half && c < half)
			recursive(r, c, half);
		// 2분면
		else if (r < half && c >= half) {
			count += (size * size) / 4;
			recursive(r, c - half, half);
		}

		// 3분면
		else if (r >= half && c < half) {
			count += (size * size) / 4 * 2;
			recursive(r - half, c, half);
		}

		// 4분면
		else if (r >= half && c >= half) {
			count += (size * size) / 4 * 3;
			recursive(r - half, c - half, half);
		}
	}
}
