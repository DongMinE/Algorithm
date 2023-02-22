package com.ssafy.ws.BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G3_17135_캐슬디펜스_망 {
	static int N, M, D, kill;
	static int[][] arr, originarr;
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		originarr = new int[N][M];
		p = new int[3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				originarr[i][j] = arr[i][j];
			}
		}

		comb(0, 0);
		System.out.println(kill);
	}

	// 병사의 위치 조합
	private static void comb(int cnt, int start) {
		if (cnt == 3) {
			arr = originarr.clone();
			solve(p[0], p[1], p[2]);
			return;
		}
		for (int i = start; i < M; i++) {
			p[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

	// 공격할 수 있는가?
	private static void solve(int p1, int p2, int p3) {
		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1 && ( 
						(distance(N,i,p[0],j)<= D) 
						|| (distance(N,i,p[1],j)<= D) 
						|| (distance(N,i,p[2],j)<=D)
						)) {
					arr[i][j] = 0;
					kill++;

				}
			}
			newarr();
		}
	}

	// arr을 원래대로
	private static void newarr() {
		for (int i = N - 1; i > 0; i--) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = originarr[i][j];
			}
		}
	}
	// 거리가 닿는가?
	private static int distance(int r1, int r2, int c1, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}

}
