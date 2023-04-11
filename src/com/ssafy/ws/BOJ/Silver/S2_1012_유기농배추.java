package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_1012_유기농배추 {
	static int m, n, res, arr[][];
	static StringTokenizer st = null;
	static int[] dr = { 0, 1, 0, -1 }, dc = { 1, 0, -1, 0 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder(); 
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken()); // 가로
			n = Integer.parseInt(st.nextToken()); // 세로
			arr = new int[n][m];
			visited = new boolean[n][m]; // 방문처리

			int t = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < t; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[b][a] = 1;
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						res++;
					}
				}
			}
			sb.append(res + "\n");
			res = 0;
		}
		System.out.println(sb);
	}

	private static void bfs(int k, int l) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] { k, l });
		visited[k][l] = true;
		
		while (!que.isEmpty()) {
			int[] num = que.poll();

			for (int i = 0; i < 4; i++) {
				int newa = num[0] + dr[i];
				int newb = num[1] + dc[i];

				if (newa < n && newb < m && newa >= 0 && newb >= 0)
					if ( !visited[newa][newb] && arr[newa][newb] == 1) {
						visited[newa][newb] = true;
						que.offer(new int[] {newa, newb});
					}
			}
		}

	}
}
