package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S1_2667_단지번호붙이기 {
	static int N, arr[][], apt, cnt;
	static boolean check[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		check = new boolean[N][N];
		apt = 1;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		// System.out.println(Arrays.deepToString(arr));
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1 && !check[i][j]) {
					cnt = 0;
					findapt(i, j);
					apt++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(apt);
	}

	private static void findapt(int x, int y) {
		int d = 0;
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		if (arr[x][y] == 1 && !check[x][y]) {
			check[x][y] = true;
			cnt++;

			for (int i = 0; i < 4; i++) {
				if (x + dr[d] >= 0 && x + dr[d] < N && y + dc[d] >= 0 && y + dc[d] < N
						&& arr[x + dr[d]][y + dc[d]] == 1) {
					x += dr[d];
					y += dc[d];
					findapt(x, y);
				}
			}

		}
	}
}
