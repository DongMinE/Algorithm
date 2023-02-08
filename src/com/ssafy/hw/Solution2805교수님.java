package com.ssafy.hw;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution2805교수님 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/sw-input2805.txt"));

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int ans = 0;
			int n = sc.nextInt();
			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++) {
				char[] temp = sc.next().toCharArray();
				for (int j = 0; j < n; j++) {
					map[i][j] = temp[j] - '0';
				}
			}
			int s = n / 2, e = n / 2;
			for (int i = 0; i < n; i++) {
				for (int k = s; k <= e; k++) {
					ans += map[i][k];
				}
				if (i >= n / 2) {
					s++;
					e--;
				} else {
					s--;
					e++;
				}
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}

	public static void main2(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/sw-input2805.txt"));

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int ans = 0;
			int n = sc.nextInt();
			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++) {
				char[] temp = sc.next().toCharArray();
				for (int j = 0; j < n; j++) {
					map[i][j] = temp[j] - '0';
				}
			}
			int r = n / 2;
			int c = n / 2;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (Math.abs(r - i) + Math.abs(c - j) <= n / 2) {
						ans += map[i][j];
					}

				}
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}