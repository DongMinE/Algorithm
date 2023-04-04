package com.ssafy.ws.SWEA.D3;

import java.util.Scanner;

public class D3_5215_햄버거다이어트2 {
	static int N, L, resScore;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			arr = new int[N][2];
			for (int i = 0; i < N; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}
			resScore = 0;
			solve(0,0,0);
			System.out.printf("#%d %d\n", tc,resScore);
		}
	}

	private static void solve(int idx, int score, int cal) {

		if (idx == N) {
			if (cal > L) return;
			resScore = Math.max(resScore, score);
			return;
		}
		solve(idx+1, score+arr[idx][0], cal+arr[idx][1]);
		solve(idx+1, score, cal);
		
	}
}