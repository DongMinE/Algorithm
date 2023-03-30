package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_10971_외판원순회2 {
	static int N;
	static int[][] arr;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int k = 1; k <= N; k++) {
			visited[k] = true;
			dfs(k,k,0,0);
		}
		System.out.println(min);
	}
	private static void dfs(int start, int now, int area, int cost) {
		if (area == N-1) {
			if (arr[now][start] != 0) {
				cost += arr[now][start];
				min = Math.min(min, cost);
			}
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && arr[now][i] != 0) {
				visited[i] = true;
				dfs(start, i, area+1, cost+arr[now][i]);
				visited[i] = false;
			}
		}
	}

}