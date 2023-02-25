package com.ssafy.ws.SWEA.D2;

import java.util.Arrays;
import java.util.Scanner;

public class D2_1954_달팽이숫자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int x = 0, y = 0, d = 0;
			int nx, ny;
			for (int i = 1; i <= N * N; i++) {
				arr[x][y] = i;
				nx = x + dr[d];
				ny = y + dc[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || arr[nx][ny] != 0) {
					d = (d + 1) % 4;
					nx = x + dr[d];
					ny = y + dc[d];
					x = nx;
					y = ny;
				} else {
					x = nx;
					y = ny;
				}
			}
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
