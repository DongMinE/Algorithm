package com.ssafy.ws.SWEA.CompetencyTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5656_뱍돌깨기 {
	private static class Point {
		int x,y,size;

		public Point(int x, int y, int size) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
		}
		
		
	}
	static int N, W, H, min;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			int[][] map = new int[H][];
			for (int i = 0; i < H; i++)
				map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			min = Integer.MAX_VALUE;
			solve(0, map);
			
			System.out.println(min);
		}
	}

	private static void solve(int cnt, int[][] map) {
		//chance 가 쏠 구슬 개수만큼 되면 max값 비교
		if (cnt == N) {
			int res = getRemain(map);
			min = Math.max(min, res);
			return;
		}
		int[][] newMap = new int[H][W];
		//구슬을 위부터 떨궈 제일위에 맞는 좌표 찾고 벽돌 깨야함
		for (int y = 0; y < W; y++) {
			int x = 0;
			while (x < H && map[x][y] == 0) x++;
			if (x == H) solve(cnt+1, map);
			else {
				copy(map, newMap);
				goShut(newMap, x, y);
				down(newMap);
				solve(cnt+1, newMap);
			}
		}
		
	}

	private static int getRemain(int[][] map) {
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] > 0)
					count++;
			}
		}

		return count;
	}

	// 벽돌 제거하고 남은 벽돌 내려주기
	private static void down(int[][] newMap) {
		for (int y = 0; y < W; y++) {
			Queue<Integer> q = new LinkedList<>();
			int x = H -1;
			while (x >= 0) {
				if (newMap[x][y] > 0) {
					q.offer(newMap[x][y]);
					newMap[x][y] = 0;
				}
				x--;
			}
			x = H-1;
			while (!q.isEmpty()) {
				newMap[x][y] = q.poll();
				x--;
			}
		}
	}

	// 벽돌 연쇄로 없애주기
	private static void goShut(int[][] newMap, int r, int c) {
		Queue<Point> q = new LinkedList<>();
		if (newMap[r][c] > 1) {
			q.offer(new Point(r, c, newMap[r][c]));
		}
		newMap[r][c] = 0;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = p.x;
				int ny = p.y;
				for (int k = 1; k < p.size; k++) {
					nx += dx[d];
					ny += dy[d];
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && newMap[nx][ny] != 0) {
						if(newMap[nx][ny] > 1) {
							q.offer(new Point(nx,ny, newMap[nx][ny]));
						}
						newMap[nx][ny] = 0;
					}
				}
			}
		}
	}

	private static void copy(int[][] map, int[][] copymap) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				copymap[i][j] = map[i][j];
			}
		}

	}
}
