package com.ssafy.live.day14;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

import com.ssafy.live.day14.AdMatrixTest2.Node;

public class AdjListTest {
	static ArrayList<Integer>[] adjList;
	static int V;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int E = sc.nextInt();

		adjList = new ArrayList[V]; // 모두 0인 상태
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<Integer>();
		}

		int from, to;
		for (int i = 0; i < E; ++i) {
			from = sc.nextInt();
			to = sc.nextInt();
			// 무향
			adjList[from].add(to);
			adjList[to].add(from);
			// 유향
			// adjMatrix[from][to] = 1;
		}
		// bfs(0);
		dfs(0, new boolean[V]);
	}

	private static void dfs(int current, boolean[] visited) {
		visited[current] = true;
		System.out.println((char) (current + 65));

		// 자신의 인접리스트 확인: adjList[current] : ArrayList<Integer>
		for (int vertex : adjList[current]) {
			if (!visited[vertex]) {
				dfs(vertex, visited);
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

			for (int vertex : adjList[current]) {
				if (!visit[vertex]) {
					queue.offer(vertex);
					visit[vertex] = true;
				}
			}
		}
	}

}
