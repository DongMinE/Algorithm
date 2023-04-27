package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_17829_222풀링 {
	static int n, arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr  = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		recur(n);
		// System.out.println(Arrays.deepToString(arr));
		System.out.println(arr[0][0]);
	}

	private static void recur(int size) {
		if(size==1) {
			return;
		}
		
		for (int i = 0; i < n; i += 2) {
			for (int j = 0; j < n; j += 2) {
				int temp[] = { arr[i][j], arr[i][j + 1], arr[i + 1][j], arr[i + 1][j + 1] };
				Arrays.sort(temp);
				arr[i/2][j/2]=temp[2];
			}
		}
		recur(size/2);
		

	}
}
