package com.ssafy.supply.For3th;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_D5_1247 {
	static int T, N;
	static int ans = Integer.MAX_VALUE;
	class Point {
		int x, y;
		public void company(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public void home(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/최적경로.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			Point company = new Point(sc.nextInt(), sc.nextInt());
			Point home = new Point(sc.nextInt(), sc.nextInt());
			N = sc.nextInt();
			N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				
			}
		}
		recursive(0, customers, new Point[i]);
	}

}
