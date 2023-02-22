package com.ssafy.ws.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G3_17135_캐슬디펜스 {
	static int N, M, D, kill;
	static char[][] arr, originarr;
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new char[N][];
		p = new int[3];
		for (int i = 0 ; i < N; i++) arr[i] = br.readLine().replaceAll(" " , "").toCharArray();
		originarr = arr.clone();
		
		comb(0,0);
		System.out.println(kill);
	}

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
	
	private static void solve(int p1, int p2, int p3) {
		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == '1' && (((Math.abs(N - i) + Math.abs(p[0] - j)) <= D)
						|| ((Math.abs(N - i) + Math.abs(p[1] - j)) <= D)
						|| ((Math.abs(N - i) + Math.abs(p[2] - j)) <= D))) {
					arr[i][j] = '0';
					kill++;

				}
			}
			newarr();
		}
	}

	private static void newarr() {
		for (int i = N-1; i > 0; i--) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = arr[i-1][j];
			}
		}
		for (int i = 0; i < M; i++) {
			arr[0][i] = '0';
		}
	}


}
