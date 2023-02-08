package com.ssafy.ws;

import java.util.Scanner;

public class Main2798_블랙잭 {
	static int n, m;
	static int[] data;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		data = new int[n];
		for (int i = 0; i < n; i++)
			data[i] = sc.nextInt();

		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					int sum = data[i] + data[j] + data[k];
					ans = Math.max(ans, sum);
				}
			}
		}

		// comb(0, 0, 0); //재귀
		System.out.println(ans);
	}

	private static void comb(int cnt, int start, int sum) {
		if (sum > m)
			return;
		if (cnt == 3) {
			ans = Math.max(sum, ans);
			return;

		}
		for  (int i = start; i < n; i++) {
			comb(cnt + 1, i + 1, sum + data[i]);
		}
	}

}
