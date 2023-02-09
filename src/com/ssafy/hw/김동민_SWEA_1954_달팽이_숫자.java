package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 김동민_SWEA_1954_달팽이_숫자 {
	public static void main(String[] args) throws IOException {
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			int dx = 0;
			int r = 0, c = 0;
			for (int k = 1; k <= n * n; k++) {
				//1부터 증가하는데
				arr[r][c] = k;
				//다음 좌표는 dr,dx에 따라 달라진다
				r += dr[dx];
				c += dc[dx];
				//다음 좌표가 0이여야 새로운 k를 쓸 수 있고 범위 안에 있어야한다.
				if (r >= 0 && r < n && c >= 0 && c < n && arr[r][c] == 0) {
					continue;
				//다른 경우는 방향을 바꿔야 할 때 뿐이다.
				} else {
					r -= dr[dx];
					c -= dc[dx];
					dx = (dx + 1) % 4;
					r += dr[dx];
					c += dc[dx];
				}
			}
			System.out.println("#"+(t+1));
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.print("\n");
			}
		}

	}

}
