package com.ssafy.ws.BOJ;

import java.util.Scanner;

public class Main2961SubSet {
	static int n, l;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			arr = new int[n][2];
			for (int i = 0; i < n; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}
			subset();
	}

	private static void subset() {
		int sum = Integer.MAX_VALUE;
		for (int i = 1; i < (1 << n); i++) {
			int sin = 1;
			int ssn = 0;
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) == 0) continue;
				sin *= arr[j][0];
				ssn += arr[j][1];
			}
			sum = Math.min(Math.abs((sin - ssn)), sum);
		}
		System.out.println(sum);
	}

}
