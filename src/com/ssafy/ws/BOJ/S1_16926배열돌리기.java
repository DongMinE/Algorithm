package com.ssafy.ws.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_16926배열돌리기 {

	public static void main(String[] args) throws IOException {
		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 가로
		int M = Integer.parseInt(st.nextToken()); // 세로
		int R = Integer.parseInt(st.nextToken()); // 돌려돌려 돌림판
		int[][] arr = new int[N][M];
		int[][] resarr = new int[N][M];
		int dx = 0;
		// 원래 배열
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int round = 0; //네모안에서 MAx
		int k = 0; //네모안에서 0 부터
		int n = N;
		int m = M;
		int temp = 0;
		int istart = 0;
		int jstart = 0;
		// 돌리기
		for (int t = 0; t < m / 2; t++) {
			if (n == m) {
				round = ((n-2)*4)+4;
			} else {
				round = n;
			}
			for (int i = istart, j=jstart; k < round; k++) {
					temp = arr[i][j];
					i += dr[dx];
					j += dc[dx];
					resarr[i][j] = temp;
					if (i >= 0 && i < n-1 && j >= 0 && j < m-1) {
						continue;
					} else {
						i -= dr[dx];
						j -= dc[dx];
						dx = (dx + 1) % 4;
						i += dr[dx];
						j += dc[dx];
					}
			}
			n-=2;
			m-=2;
			istart++;
			jstart++;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(resarr[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.printf("%d %d %d", round, n, m);
	}
}
