package com.ssafy.ws.SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
1
3 3
1 2 1
2 3 2
1 3 3

*/
public class D4_3124_최소스패닝트리망 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] data = new int[N][N];
			boolean[] visit = new boolean[N];
			int[] minCost = new int[N];

			for (int i = 0; i < N; i++) {
				Arrays.fill(data[i], Integer.MAX_VALUE);
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				data[a - 1][b - 1] = data[b - 1][a - 1] = Integer.parseInt(st.nextToken());
			}

			Arrays.fill(minCost, Integer.MAX_VALUE);

			//System.out.println(Arrays.toString(minCost));
			//System.out.println(Arrays.deepToString(data));
			
			minCost[0] = 0;
			int ans = 0; // 최소 신장트리의 간선의 비용을 담을 변수
			for (int n = 0; n < N; n++) {
				int min = Integer.MAX_VALUE, minVertex = -1;
				for (int i = 0; i < N; i++) {
					if (!visit[i] && min > minCost[i]) {
						min = minCost[i];
						minVertex = i;
					}
				}
				visit[minVertex] = true;
				ans += min;

				for (int i = 0; i < N; i++) {
					if (!visit[i] && data[minVertex][i] != 0 && minCost[i] > data[minVertex][i]) {
						minCost[i] = data[minVertex][i];
					}
				}
			}
//			System.out.println(Arrays.toString(minCost));
//			System.out.println(Arrays.deepToString(data));
			System.out.printf("#%d %d\n",tc+1,ans);
		}
	}
}
