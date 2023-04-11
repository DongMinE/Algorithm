package com.ssafy.ws.BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_7576_토마토 {
	static int m, n, res, arr[][];
	static int[] dr = { 0, 1, 0, -1 }, dc = { 1, 0, -1, 0 };
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[m][n];
		visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		for (int[] a : arr) {
//			System.out.println(Arrays.toString(a));
//		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && arr[i][j] == 1) {
					bfs(i, j);
				}
			}
		}
		System.out.println(res);

	}
	private static void bfs(int a, int b) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {a,b});
		visited[a][b] = true;
		res++;
		
		while(!que.isEmpty()) {
			int[] num = que.poll();
			
			for (int i = 0; i < 4; i++) {
				int newa = num[0] + dr[i];
				int newb = num[1] + dc[i];
				
				if (newa < m && newb < n && newa >= 0 && newb >= 0) {
					if (arr[newa][newb] == 0 && !visited[newa][newb]) {
						visited[newa][newb] = true;
						arr[newa][newb] = 1;
						bfs(newa, newb);
					}
				}
			}
			
			
		}
	}
}
