package com.ssafy.ws.BOJ.Gold;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class G5_9205_맥주마시면서걸어가기_BFS_인접행렬 {
	static int N;
    static int map[][];
	static Point arr[];
	static boolean visited[];

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(), t = 0;
		while (t++ < T) {
			N = sc.nextInt();
			map = new int[N + 2][N + 2];
			arr = new Point[N + 2];
			visited = new boolean[N + 2];
			for (int i = 0; i < N + 2; i++) {
				arr[i] = new Point(sc.nextInt(), sc.nextInt());
			}

			for (int i = 0; i < N + 1; i++) {
				for (int j = i + 1; j < N + 2; j++) {
					if (checkDist(i, j)) {
						map[i][j] = map[j][i] = 1;
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
			if (vertex == N + 1) return "happy";

			for (int i = 0; i < N + 2; i++) {
				if (visited[i] || map[vertex][i] == 0) continue;
				q.add(i);
				visited[i] = true;
			}
		}
		return "sad";
	}
}
