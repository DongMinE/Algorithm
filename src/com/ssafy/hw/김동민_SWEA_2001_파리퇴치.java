package com.ssafy.hw;

import java.util.Scanner;

public class 김동민_SWEA_2001_파리퇴치 {
	static int[][] arr;
	static int n, m;
	static int kill, firstkill;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			n = sc.nextInt();
			m = sc.nextInt();
			arr = new int[n][n];
			kill = 0;
			firstkill = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			pari(0);
			
			System.out.println(kill);
		}
	}

	private static void pari(int start) {
		for (int i = 0; i < n - m + 1; i++) {
			for (int j = 0; j < n - m + 1; j++) {
				firstkill = 0;
				for (int k = 0; k < m; k++) {
					for (int kk = 0; kk < m; kk++) {
						firstkill += arr[i + k][j + kk];
					}
				}
				kill = Math.max(kill, firstkill);
			}
		}

	}

}
