package com.ssafy.ws.SWEA.D3;

import java.util.Scanner;

public class D3_5215_햄버거다이어트 {
	static int N, L, resScore;
	static int[][] arr;
	static boolean[] visit;
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
			visit = new boolean[N];
			solve(0,0,0);
			System.out.printf("#%d %d\n", tc,resScore);
		}
	}

	private static void solve(int cnt, int score, int cal) {

		if (cnt == N) {
			score = 0;
			cal = 0;
			for (int i = 0; i < N; i++) {
				if (!visit[i]) continue;
				
				score += arr[i][0];
				cal += arr[i][1];
				if (cal > L) return;
			}
			resScore = Math.max(resScore, score);
			return;
		}

			visit[cnt] = true;
			solve(cnt+1, score, cal);
			visit[cnt] = false;
			solve(cnt+1, score, cal);

		
		
	}
}
