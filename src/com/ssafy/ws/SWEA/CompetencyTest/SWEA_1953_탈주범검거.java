package com.ssafy.ws.SWEA.CompetencyTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_탈주범검거 {
	static class Point {
		int x, y, cnt;

		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	static String[] t = { "", "0123", "02", "13", "03", "23", "12", "01" };
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, -1, 0, 1 };
	static int map[][], N, M, R, C, L, ans;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			ans = 1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs();
			System.out.printf("#%d %d\n",tc, ans);
		}
	}

	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		boolean visit[][] = new boolean[N][M];
		
		q.offer(new Point(R,C,1));
		visit[R][C] = true;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			if (cur.cnt == L) break;
			int curTunnel = map[cur.x][cur.y];
			for (int d = 0; d < 4; d++) {
				int nr = cur.x + dr[d];
				int nc = cur.y + dc[d];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc] || map[nr][nc] == 0)
					continue;
					int nextTunnel = map[nr][nc];
					String opDir = Integer.toString((d+2) % 4);
					if (!t[nextTunnel].contains(opDir)) continue;
					if (curTunnel == 2 && d % 2 != 0) continue;
					if (curTunnel == 3 && d % 2 == 0) continue;
					if (curTunnel == 4 && d % 3 != 0) continue;
					if (curTunnel == 5 && d < 2) continue;
					if (curTunnel == 6 && d % 3 == 0) continue;
					if (curTunnel == 7 && d > 1) continue;
					visit[nr][nc] = true;
					q.offer(new Point(nr,nc,cur.cnt+1));
					ans++;
				}
		}
	}
}
