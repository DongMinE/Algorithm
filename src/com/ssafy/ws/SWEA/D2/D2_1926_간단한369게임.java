package com.ssafy.ws.SWEA.D2;

import java.util.Scanner;

public class D2_1926_간단한369게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			String str = String.valueOf(i);
			if (str.contains("3") || str.contains("6") || str.contains("9")) {
				for (int j = 0; j < str.length(); j++) {
					if (str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9') {
						System.out.print("-");
					}
				}
				System.out.print(" ");
			}
			else System.out.print(i + " ");
		}
	}
}
