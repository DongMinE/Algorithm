package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class S1_4963_섬의개수 {
	static int N, M, arr[][], cnt, nx, ny;
	static boolean check[][];
	static int[] dr = {0, 0, 1, -1, -1, 1, -1, 1};
	static int[] dc = {1, -1, 0, 0, -1, 1, 1, -1};

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		while (true) {
			N = sc.nextInt();
			M = sc.nextInt();

			if (N == 0 && M == 0)break;
			
			arr = new int[M][N];
			check = new boolean[M][N];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			cnt = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1 && !check[i][j]) {
						cnt++;
						dfs(i, j);
					}
				}
			}
			System.out.println(cnt);
		}
	}

	private static void dfs(int x, int y) {
		check[x][y] = true;
		for (int i = 0; i < 8; i++) {
			nx = x + dr[i];
			ny = y + dc[i];
			if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
				if (arr[nx][ny] == 1 && !check[nx][ny])
				dfs(nx, ny);

			}

		}
	}
}
