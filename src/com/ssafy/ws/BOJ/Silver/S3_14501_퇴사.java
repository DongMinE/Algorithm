package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_14501_퇴사 {
	static int maxMoney, N, idx, sangDam, money;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		dfs(0, 0);
		System.out.println(maxMoney);
	}

	private static void dfs(int work, int money) {
		if (work < N) {
			maxMoney = Math.max(money, maxMoney);
			return;
		}
		if (work > N)
			return;
		dfs(work + arr[work][0], money + arr[work][1]);
		dfs(work + 1, money);
	}

}
