package com.ssafy.ws.SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_5643_키순서 {

	static int N, M;
	static int[][] key;
	static int inf = 99;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			key = new int[N + 1][N + 1];
			StringTokenizer st;
			// 처음부터 키 비교 해준 값 넣어주기
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				key[a][b] = 1;
			}
			// 현재 비교 못한 위치에 inf 넣어주
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i != j && key[i][j] == 0)
						key[i][j] = inf;
				}
			}
			// 플로이드 돌려서 내가 경유지를 거쳐 갈 수 있다 = 나보다 크다
			for (int k = 1; k <= N; k++) { // 경유
				for (int i = 1; i <= N; i++) { // 출발
					if (i == k)
						continue;
					for (int j = 1; j <= N; j++) { // 도착
						if (i == j || j == k)
							continue;
						key[i][j] = Math.min(key[i][j], key[i][k] + key[k][j]);

					}
				}
			}
//			for (int[] a : key) {
//				System.out.println(Arrays.toString(a));
//			}
			
			//가면 큰놈 오면 작은놈?
			int res = 0;
			for (int i = 1; i <= N; i++) {
				int small = 0, big = 0;
				for (int j = 1; j <= N; j++) {
					if (i != j && key[i][j] < inf) small++;
					if (i != j && key[j][i] < inf) big++;
				}
				if (small + big == N-1) res++;
			}
			
		System.out.println("#"+t+ " "+res);	
		}

	}
}











