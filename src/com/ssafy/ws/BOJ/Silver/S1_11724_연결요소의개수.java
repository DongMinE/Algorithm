package com.ssafy.ws.BOJ.Silver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S1_11724_연결요소의개수 {
	static int N;
	static int M;
	static int cnt;
	static int[][] arr;
	static boolean[] check;
	static Queue<Integer> que;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N + 1][N + 1];
		check = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = arr[b][a] = 1;
		}
		cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (!check[i]) {
				bfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);

	}

	private static void bfs(int start) {
		que = new LinkedList<Integer>();
		check[start] = true;
		que.add(start);
		while (!que.isEmpty()) {
			int temp = que.poll();
			for (int i = 0; i < N+1; i++) {
				if (!check[i] && arr[temp][i] == 1) {
					que.add(i);
					check[i] = true;
				}
			}
		}
	}
}
