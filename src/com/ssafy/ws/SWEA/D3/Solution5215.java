package com.ssafy.ws.SWEA.D3;

import java.util.Scanner;

public class Solution5215 {
	static int n, l;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			n = sc.nextInt();
			l = sc.nextInt();
			arr = new int[n][2];
			for (int i = 0; i < n; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}
			System.out.print("#" + t + " ");
			subset();
		}
	}

	private static void subset() {
		int ans = 0;
		for (int i = 1; i < (1 << n); i++) {
			int sum = 0;
			int score = 0;
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) == 0) continue;
				score += arr[j][0];
				sum += arr[j][1];
			}
			if (sum > l) continue;
			ans = Math.max(score, ans);
		}
		System.out.println(ans);
	}

}
