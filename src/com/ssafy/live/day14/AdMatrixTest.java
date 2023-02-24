package com.ssafy.live.day14;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class AdMatrixTest {
	static int[][] adjmatrix;
	static int V, E;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();

		adjmatrix = new int[V][V];

		int from, to;
		for (int i = 0; i < E; ++i) {
			from = sc.nextInt();
			to = sc.nextInt();
			// 무향
			adjmatrix[to][from] = adjmatrix[from][to] = 1;
		}
		bfs(0);
		dfs(0, new boolean[V]);
	}
	private static void dfs(int current, boolean[] visited) {
		visited[current] = true;
		System.out.println((char) (current + 65));
		
		for (int i = 0; i < V; i++) {
			if (adjmatrix[current][i] != 0 && !visited[i]) {
				dfs(i, visited);
			}
		}
	}

	private static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visit = new boolean[V];

		queue.offer(start);
		visit[start] = true;

		int current = 0;
		while (!queue.isEmpty()) {
			current = queue.poll();
			System.out.println((char) (current + 65));

			for (int i = 0; i < V; i++) {
				if (adjmatrix[current][i] != 0 && !visit[i]) {
					queue.offer(i);
					visit[i] = true;
				}
			}
		}
	}
}
