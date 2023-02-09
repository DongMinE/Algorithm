package com.ssafy.ws.BOJ;

import java.awt.Point;
import java.util.Scanner;

public class Main2023교수님 {

static int N, M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int v : new int[] {2, 3, 5, 7}) {
			solve(v, N - 1);
		}
		sc.close();
	}

	static void solve(int v, int n) {
		if (n == 0) {
			System.out.println(v);
			return;
		}

		for (int i = 1; i < 10; i += 2) {
			int num = 10 * v + i;
			if (isPrim(num)) {
				solve(num, n - 1);
			}
		}
	}

	static boolean isPrim(int num) {
		for (int i = 2; i * i <= num; i++) if (num % i == 0) return false;

		return true;
	}
}
