package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S1_1992_쿼드드리 {
	static int N, arr[][];
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		Tree(0, 0, N);
		System.out.println(sb);
	}

	private static void Tree(int x, int y, int size) {
		if (ischeck(x, y, size)) {
			sb.append(arr[x][y]);
			return;
		}
		int newsize = size / 2;

		sb.append("(");
		Tree(x, y, newsize);
		Tree(x, y + newsize, newsize);
		Tree(x + newsize, y, newsize);
		Tree(x + newsize, y + newsize, newsize);
		sb.append(")");

	}

	private static boolean ischeck(int x, int y, int size) {
		int value = arr[x][y];
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (value != arr[i][j])
					return false;
			}
		}
		return true;
	}
}
