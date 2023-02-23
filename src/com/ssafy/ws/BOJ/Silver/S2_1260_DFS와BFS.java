package com.ssafy.ws.BOJ.Silver;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class S2_1260_DFS와BFS {
	static int[][] arr;
	static boolean[] check;
	static int N, M, V;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		arr = new int[N + 1][N + 1];
		check = new boolean[N + 1];
		check[0] = true;
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = arr[b][a] = 1;
		}
		dfs(V);
		System.out.println();
		check = new boolean[N + 1];
		check[0] = true;
		bfs(V);
	}

	private static void dfs(int start) {
		check[start] = true;
		System.out.print(start + " ");
		for (int i = 1; i < N + 1; i++) {
			if (arr[start][i] == 1 && !check[i])
				dfs(i);
		}

	}

	private static void bfs(int start) {

		Queue<Integer> que = new ArrayDeque<>();
		que.offer(start);
		check[start] = true;

		int cur = 0;
		while (!que.isEmpty()) {
			cur = que.poll();
			System.out.print(cur + " ");

			for (int i = 1; i < N + 1; i++) {
				if (!check[i] && arr[cur][i] == 1) {
					que.offer(i);
					check[i] = true;
				}
			}
		}
	}
}
