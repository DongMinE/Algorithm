package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3040 {
	static int[] arr = new int[9];
	static int[] ans = new int[7];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dfs(0, 0);
	}

	private static void dfs(int cnt, int start) {
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += ans[i];
			}
			if (sum == 100) {
				for (int j = 0; j < 7; j++) {
					System.out.println(ans[j]);

				}
				return;
			}
			return;

		}
		for (int i = start; i < 9; i++) {
			ans[cnt] = arr[i];
			dfs(cnt + 1, i + 1);

		}
	}

}
