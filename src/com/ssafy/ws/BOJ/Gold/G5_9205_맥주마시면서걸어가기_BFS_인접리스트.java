package com.ssafy.ws.BOJ.Gold;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class G5_9205_맥주마시면서걸어가기_BFS_인접리스트 {
	static int N;
	static Point arr[];
	static boolean visited[];
	static ArrayList<Integer> adjList[];

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(), t = 0;
		while (t++ < T) {
			N = sc.nextInt();
			adjList = new ArrayList[N + 2];
			visited = new boolean[N + 2];
			arr = new Point[N + 2];
			for (int i = 0; i < N + 2; i++) {
				arr[i] = new Point(sc.nextInt(), sc.nextInt());
			}

			for (int i = 0; i < N + 2; i++) adjList[i] = new ArrayList<>();
			for (int i = 0; i < N + 1; i++) {
				for (int j = i + 1; j < N + 2; j++) {
					if (checkDist(i, j)) {
						adjList[i].add(j);
						adjList[j].add(i);
					}
				}
			}
			System.out.println(bfs());
		}
	}

	static boolean checkDist(int i, int j) {
		return Math.abs(arr[i].x - arr[j].x) + Math.abs(arr[i].y - arr[j].y) <= 1000;
	}

	static String bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		visited[0] = true;

		while (!q.isEmpty()) {
			int vertex = q.poll();
			if (vertex == N + 1)
				return "happy";

			for (int i = 0; i < adjList[vertex].size(); i++) {
				int v = adjList[vertex].get(i);
				if (!visited[v]) {
					q.add(v);
					visited[v] = true;
				}
			}
		}
		return "sad";
	}
}

