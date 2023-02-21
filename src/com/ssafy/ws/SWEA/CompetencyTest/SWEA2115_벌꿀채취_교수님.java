package com.ssafy.ws.SWEA.CompetencyTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA2115_벌꿀채취_교수님 {
	// N 벌통의 크기 3 <= N <=10
	// M 벌통의 개수 1 <= M <= 5
	// 꿀 채취 최대 양 10 <= C <= 30
	static int N, M, C, ans;
	static int[][] map, profit;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/swea2115.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			profit = new int[N][N];
			// 기본배열
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 이익
			setProfit(); // 각 좌표에서의 최대 이익
			setPosition(); // 조합의 자리 결정

			System.out.println("#" + tc + " " + ans); 
			ans = 0;
		}
		// for (int[] v : arr) System.out.println(Arrays.toString(v));
	}

	private static void setPosition() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
				// 일꾼 1의 위치, map[i][j]
				// 일꾼 2의 위치, 같은 행일때
				for (int c = j + M; c <= N - M; c++)
					ans = Math.max(ans, profit[i][j] + profit[i][c]);

				// 일꾼 2의 위치, 다른 행일때
				for (int r = i + 1; r < N; r++)
					for (int c = 0; c <= N - M; c++)
						ans = Math.max(ans, profit[i][j] + profit[r][c]);
			}
		}
	}

	private static void setProfit() {
		for (int i = 0; i < N; i++)
			for (int j = 0; j <= N - M; j++)
				setMaxPorfit(i, j, 0, 0, 0);

	}

	private static void setMaxPorfit(int i, int j, int cnt, int cSum, int pSum) {
		if (cSum > C)
			return;
		if (cnt == M) {
			profit[i][j - M] = Math.max(profit[i][j - M], pSum);
			return;
		}
		setMaxPorfit(i, j + 1, cnt + 1, cSum, pSum);
		setMaxPorfit(i, j + 1, cnt + 1, cSum + map[i][j], pSum + map[i][j] * map[i][j]);

	}

}
