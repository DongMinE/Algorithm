package com.ssafy.ws.SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D2_1204_최빈수구하기 {
	static int[] check;
	static int max, cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int Case = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			max = 0;
			cnt = 0;
			check = new int[101];
			for (int i = 0; i < 1000; i++) {
				check[Integer.parseInt(st.nextToken())]++;
			}
			for (int i = 0; i < check.length; i++) {
				if (check[i] >= max) {
					max = check[i];
					cnt = i;
				}
			}
			
			System.out.printf("#%d %d\n",tc, cnt);
		}
	}
}
