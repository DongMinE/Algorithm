package com.ssafy.selfCodingTest;

import java.util.Scanner;

public class test {
	static int M, A, ans, pathA[], pathB[];
	static User u1,u2;
	static AP[] ap;
	static int[] dr = { 0, -1, 0, 1, 0 };
	static int[] dc = { 0, 0, 1, 0, -1 };
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			M = sc.nextInt();
			A = sc.nextInt();
			for (int i = 0; i < M; i++) {
				pathA[i] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				pathB[i] = sc.nextInt();
			}
			ap = new AP[A];
			for (int i = 0; i < A; i++) {
				ap[i] = new AP(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());
			}
			u1 = new User(1,1);
			u2 = new User(10,10);

			solve();
			System.out.printf("#%d %d",tc,ans);
			ans = 0;
		}
	}

	private static void solve() {
		
		
		
	}
}
class User {
	int x, y;
	User(int x, int y){
		this.x = x;
		this.y = y;
	}
}
class AP {
	int r,c,C,P;
	
	AP(int r, int c, int C, int P) {
		this.r = r;
		this.c = c;
		this.C = C;
		this.P = P;
	}
}
