package com.ssafy.ws.SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D2_14510_나무높이 {
	static int size, arr[], max, odd, even, ans;

	public static void main(String[] args) throws IOException {
		// 테케 30개
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			size = Integer.parseInt(br.readLine());
			arr = new int[size];
			max = 0; // 가장 높은 나무
			odd = 0;
			even = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < size; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				max = Math.max(arr[i], max);
			}
			for (int i = 0; i < size; i++) {
				odd += (max - arr[i]) % 2;
				even += (max - arr[i]) / 2;
			}
			
		}

	}
}
