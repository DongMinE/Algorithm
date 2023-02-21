package com.ssafy.ws.BOJ.Gold;

import java.util.Scanner;

import java.util.Scanner;

public class G4_17406_배열돌리기4 {
	static int N, M, K, map[][];
	static int dx[] = { 0, 1, 0, -1 }, dy[] = { 1, 0, -1, 0 };
	static int[][] kArr;
	static int ans = 1 << 30;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][M];
		kArr = new int[K][];
		for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) map[i][j] = sc.nextInt();
		for (int i = 0; i < K; i++) kArr[i] = new int[] {sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt()};
		perm(0, 0);
		System.out.println(ans);
		sc.close();
	}
	
	static void perm(int depth, int flag) {
		if (depth == K) {
			ans = Math.min(ans, findMinValue());
			return;
		}
		// 순열 처리 후 원상태로 되돌리기 위해서 카피
		int[][] temp = new int[N][];
		for (int i = 0; i < N; i++) temp[i] = map[i].clone();

		for (int i = 0; i < K; i++) {
			if((flag & 1 << i) != 0) continue;
			rotate(kArr[i][0], kArr[i][1], kArr[i][2]);
			perm(depth + 1, flag | 1 << i);
			for (int x = 0; x < N; x++) map[x] = temp[x].clone();
		}
	}
	
	// 회전 메서드
	static void rotate(int x, int y, int s) {
		for (int cnt = 1; cnt <= s; cnt++) {
			int nx = x - cnt;
			int ny = y - cnt;
			int temp = map[nx][ny];
			for (int d = 0; d < 4; d++) {
				for (int i = 0; i < 2 * cnt; i++) {
					nx += dx[d];
					ny += dy[d];
					int val = map[nx][ny];
					map[nx][ny] = temp;
					temp = val;
				}
			}
		}
	}

	// 행 최솟값 찾는 메서드
	static int findMinValue() {
		int min = 1 << 30;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) sum += map[i][j];
			min = Math.min(min, sum);
		}
		return min;
	}	
}