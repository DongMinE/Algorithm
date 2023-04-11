package com.ssafy.ws.BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_7576_토마토 {
	static int m, n, res, arr[][];
	static int[] dr = { 0, 1, 0, -1 }, dc = { 1, 0, -1, 0 };
	static Queue<int[]> que = new LinkedList<>();
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[m][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					que.add(new int[] { i, j });
			}
		}
		bfs();
		System.out.println(max);

	}

	private static void bfs() {
		while (!que.isEmpty()) {
			int[] num = que.poll();

			for (int i = 0; i < 4; i++) {
				int newa = num[0] + dr[i];
				int newb = num[1] + dc[i];

				if (newa < m && newb < n && newa >= 0 && newb >= 0) {
					if (arr[newa][newb] == 0) {
						arr[newa][newb] = arr[num[0]][num[1]] + 1;
						que.add(new int[] { newa, newb });
					}
				}
			}
		}
		countDay();
	}

	private static void countDay() {
		if (check())
			max = -1;
		else {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (max < arr[i][j]) {
						max = arr[i][j];
					}
				}
			}
			max = max - 1;
		}
	}

	private static boolean check() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 0)
					return true;
			}
		}
		return false;
	}
}
