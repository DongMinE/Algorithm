package com.ssafy.ws.BOJ.nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15650 {
	static int n, r;
	static int[] inputs, numbers;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		inputs = new int[n];
		numbers = new int[r];
		visited = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			inputs[i] = i+1;
		}
		comb(0, 0);
		System.out.println(sb);

	}

	private static void comb(int cnt, int start) {
		sb = new StringBuilder();
		if (cnt == r){
			cnt++;
			System.out.println(Arrays.toString(numbers));
//			for (int i = 0; i < n; i++) {
//				sb.append(numbers[i] + " ");
//			}
//			sb.append("\n");
			return;
		}
		for (int i = start; i < n; i++) {
			numbers[cnt] = inputs[i];
			comb(cnt + 1, i + 1 );
		
		}
	}

}
