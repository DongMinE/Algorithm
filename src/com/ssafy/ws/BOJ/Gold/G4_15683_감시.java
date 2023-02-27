package com.ssafy.ws.BOJ.Gold;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class G4_15683_감시 {
	static int N, M, ans = 1 << 30;
	static int[][] map;
	static class CCTV {
		int r, c, type;
		CCTV(int r, int c, int type) {
			this.r = r;
			this.c = c;
			this.type = type;
		}
	}
	static List<CCTV> cctvList = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();  // 0, 6, 1 - 5
				if (map[i][j] >= 1 && map[i][j] <= 5) {
					cctvList.add(new CCTV(i, j, map[i][j]));
				}
			}
		}
		solve(0, map);
		System.out.println(ans);
	}
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] dir = {
			{}, // 0번 CCTV는 없으므로 그냥 버리는 개념
			{1}, // 1번 CCTV 
			{1, 3}, // 2번 
			{0, 1}, // 3번 
			{0, 1, 3}, // 4번 
			{0, 1, 2, 3}, // 5번 
	};
	static int[] dCnt = {0, 4, 2, 4, 4, 1};
	private static void solve(int idx, int[][] map) {
		if (idx == cctvList.size()) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) {
						cnt++;
					}
				}
			}
			ans = Math.min(ans, cnt);
			return;
		}
		
		CCTV cctv = cctvList.get(idx);
		for (int d = 0; d < dCnt[cctv.type]; d++) {  // 90도씩 돌리는 작업
			int[][] copyMap = copyMap(map);
			// CCTV 타입에 따른 감시 영역 체크
			for (int i = 0; i < dir[cctv.type].length; i++) {
				int nd = (dir[cctv.type][i] + d) % 4;
				int nr = cctv.r;
				int nc = cctv.c;
				while (true) {
					nr += dr[nd];
					nc += dc[nd];
					if (nr < 0 || nr >= N || nc < 0 || nc >= M) break;
					if (copyMap[nr][nc] == 6) break;
					copyMap[nr][nc] = 9;
				}
			}
			solve(idx + 1, copyMap);
		}
	}
	private static int[][] copyMap(int[][] map) {
		int[][] copy = new int[N][];
		for (int i = 0; i < N; i++) {
			copy[i] = map[i].clone();
		}
		return copy;
	}
}








