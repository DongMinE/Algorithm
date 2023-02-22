package com.ssafy.ws.SWEA.D2;

import java.util.HashSet;
import java.util.Scanner;

public class D2_1974_스도쿠 {
	static int T, N, Ans;
	static int[][] map = new int[9][9];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			for (int r = 0; r < 9; r++) {
				for (int c = 0; c < 9; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			// print(map);

			Ans = solve();

			System.out.printf("#%d %d\n", tc, Ans);
		}
	}

	static HashSet<Integer> hs = new HashSet<>();

	private static int solve() {
		// horizontal
		for (int i = 0; i < 9; i++) {
			hs.clear();
			for (int j = 0; j < 9; j++) {
				hs.add(map[i][j]);
			}
			if (hs.size() < 9)
				return 0;
		}
		// vertical
		for (int i = 0; i < 9; i++) {
			hs.clear();
			for (int j = 0; j < 9; j++) {
				hs.add(map[j][i]);
			}
			if (hs.size() < 9)
				return 0;
		}
		// squre
		// 큰사각형
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				hs.clear();
				// 작은 사각형
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						int m = map[i * 3 + k][j * 3 + l];
						hs.add(m);
					}
				}
				if (hs.size() < 9)
					return 0;
			}
		}

		return 1;
	}

	private static void print(int[][] map) {
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}
}
