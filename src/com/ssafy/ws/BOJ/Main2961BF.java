package com.ssafy.ws.BOJ;

import java.util.Scanner;

public class Main2961BF {
	static int n, sin, ssn, ans;
	static int[][] arr;
	static int sum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			arr = new int[n][2];
			sum = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}
			subset(0,0);
	}

	private static void subset(int idx, int sum) {
		
		if (idx == n) return;
		sin *= arr[idx][0];
		ssn += arr[idx][1];
		sum = Math.min(Math.abs((sin - ssn)), sum);
		
	}

}
