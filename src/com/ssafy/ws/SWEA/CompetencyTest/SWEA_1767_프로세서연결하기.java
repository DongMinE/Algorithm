package com.ssafy.ws.SWEA.CompetencyTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1767_프로세서연결하기 {
	static class position {
		int x, y;

		public position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[][] arr;
	static int N, minWire, maxCore;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static List<position> posList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			posList = new ArrayList<>();
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < N; m++) {
					int tell = Integer.parseInt(st.nextToken());
					if (tell == 1) {
						arr[n][m] = 1;
						// 가장자리가 아니면서 1인 위치는 구별하기 위해 2로 변경해줌
						if (n == 0 || m == 0 || n == N - 1 || m == N - 1)
							continue;
						posList.add(new position(n, m));
					}
				}
			}
			minWire = Integer.MAX_VALUE;
			maxCore = Integer.MIN_VALUE;
			dfs(0, 0, 0);
			sb.append("#" + (tc + 1) + " " + minWire + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void dfs(int idx, int coreCnt, int wireCnt) {
		if (idx == posList.size()) {

			if (maxCore < coreCnt) { // 연결한 코어가 더 많아야함
				maxCore = coreCnt;
				minWire = wireCnt;
			} else if (maxCore == coreCnt) {
				minWire = Math.min(wireCnt, minWire);
			}
			return;
		}

		int x = posList.get(idx).x;
		int y = posList.get(idx).y;

		for (int d = 0; d < 4; d++) {
			int count = 0, nx = x, ny = y;
			while (true) {
				nx += dr[d];
				ny += dc[d];

				// 끝까지 갔다면 연결 가능함
				if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
					break;
				}
				// 1을 만나면 다른 방향으로 가야함
				if (arr[nx][ny] == 1) {
					count = 0;
					break;
				}
				// 막히지 않는다면 1증가
				count++;
			}
			int xx = x;
			int yy = y;
			// 끝까지 간 라인을 1로 채워줌
			for (int i = 0; i < count; i++) {
				xx += dr[d];
				yy += dc[d];
				arr[xx][yy] = 1;
			}
			// 4방향 모두 진행 못했다면 해당 코어는 연결 불가능 다음 코어로 진행
			if (count == 0)
				dfs(idx + 1, coreCnt, wireCnt);
			else {
				// 끝까지 연결한 코어의 개수+1, 길이+
				dfs(idx + 1, coreCnt + 1, wireCnt + count);
				// 다시 0으로 돌려주기
				xx = x;
				yy = y;
				for (int i = 0; i < count; i++) {
					xx += dr[d];
					yy += dc[d];
					arr[xx][yy] = 0;
				}
			}

		}
	}
}
