package com.ssafy.ws.BOJ.Silver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class S1_2667_단지번호붙이기_교수님 {
	static int N, cnt;
	static char[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[N][];

		for (int i = 0; i < N; i++)
			map[i] = sc.next().toCharArray();

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) if (map[i][j] != '0') {
				dfs(i, j);
				list.add(cnt);
				cnt = 0;
		}
		System.out.println(list.size());
		list.stream().sorted().forEach(System.out::println);
	}

	static int[] dr = { 0, 0, -1, 1 }, dc = { -1, 1, 0, 0 };
	private static void dfs(int i, int j) {
		map[i][j] = '0';
		cnt++;
		for (int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
			if (map[nr][nc] != '0') {
				dfs(nr, nc);
			}
		}
	}
}
