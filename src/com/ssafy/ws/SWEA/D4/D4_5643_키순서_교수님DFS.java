package com.ssafy.ws.SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_5643_키순서_교수님DFS {
	static int N, M, adj[][], radj[][], cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());

			adj = new int[N + 1][N + 1]; // 자신보다 키가 큰 관계
			radj = new int[N + 1][N + 1]; // 자신보다 키가 작은 관계
			int a, b;
			StringTokenizer st = null;
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				radj[b][a] = adj[a][b] = 1;
			}

			int ans = 0;
			for (int k = 1; k <= N; k++) {
				cnt = 0;
				dfs(k, adj, new boolean[N + 1]);
				dfs(k, radj, new boolean[N + 1]);
				if (cnt == N - 1)
					ans++;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void dfs(int cur, int[][] adj, boolean[] visited) {
		// adj : 자신보다 큰 관계 인접행렬이면 자신보다 큰 정점 탐색
		// adj : 자신보다 작은 관계 인접행렬이면 자신보다 큰 정점 탐색
		visited[cur] = true;
		for (int i = 1; i <= N; i++) {
			if (adj[cur][i] == 1 && !visited[i]) {
				cnt++;
				dfs(i, adj, visited);
			}

		}
	}

}
