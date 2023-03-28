package com.ssafy.ws;

import java.util.Scanner;

public class SW1 {
	static int res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		System.out.println(sol(T));
	}

	private static int sol(int t) {
		if (t <= 1)
			return 2;
		if (t == 2)
			return 3;
		
		return sol(t-1)+sol(t-2);
	}

}
