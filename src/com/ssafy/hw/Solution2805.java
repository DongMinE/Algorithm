package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2805 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			for (int arri = 0; arri < n; arri++) {
				String str = br.readLine();
				int[] line = new int[n];
				for (int j = 0; j < n; j++) {
					line[j] = str.charAt(j) - '0';
				}
				arr[arri] = line;
			}

			int start = n / 2;
			int end = n / 2;
			int ans = 0;
			for (int i = 0; i < n; i++) {
				for (int j = start; j < end+1; j++) {
					ans += arr[i][j];
				}
				if (i < n / 2) {
					start--;
					end++;
				} else {
					start++;
					end--;
				}
			}
			System.out.printf("#%d %d\n", t+1,ans);
		}

	}
}