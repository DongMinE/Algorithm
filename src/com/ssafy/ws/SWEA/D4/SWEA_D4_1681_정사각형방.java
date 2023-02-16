package com.ssafy.ws.SWEA.D4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_D4_1681_정사각형방 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/swea1681.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int[] cnt = new int[n * n + 1];
			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					map[i][j] = sc.nextInt();

			int[] dr = { 1, -1, 0, 0 };
			int[] dc = { 0, 0, -1, 1 };
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if (nr < 0 || nc < 0 || nr >= n || nc >= n)
							continue;

						if (map[nr][nc] == map[i][j]+1) {
							++cnt[map[i][j]];
							break;
						}
					}
				}
			}
			int loc = 1000000, max = 1, move = 1;
			for (int i = n * n; i > 0; --i) {
				if (cnt[i] == 0) {
					move = 1;
					continue;
				}
				++move;
				if (move >= max) {
					max = move;
					loc = i;
				}
			}
			System.out.printf("#%d %d %d\n", t, loc, max);
		}

		sc.close();
	}
}
