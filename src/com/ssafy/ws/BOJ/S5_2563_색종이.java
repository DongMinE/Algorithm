package com.ssafy.ws.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5_2563_색종이 {
	static boolean[][] arr = new boolean[101][101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			for (int i = n; i < n + 10; i++) {
				for (int j = m; j < m + 10; j++) {
					if (!arr[i][j]) {
						arr[i][j] = true;
						cnt++;
					}
				}
			}
		}
		System.out.print(cnt);
	}
}
