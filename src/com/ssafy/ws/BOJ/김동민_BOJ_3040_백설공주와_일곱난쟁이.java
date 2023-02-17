package com.ssafy.ws.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 김동민_BOJ_3040_백설공주와_일곱난쟁이 {
	static int res = 0;
	static int[] arr = new int[9];
	static int[] resarr = new int[7];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		solve(0, 0);
	}

	private static void solve(int cnt, int start) {
		int sum = 0;
		if (cnt == 7) {
			for (int i = 0; i < 7; i++) {
				sum += resarr[i];
			}
			if (sum == 100) {
				for(int v : resarr) System.out.println(v);
			}
			return;
		}
		
		for (int i = start; i < 9; i++) {
			resarr[cnt] = arr[i];
			solve(cnt+1, i+1);
		}
		
	}
}
