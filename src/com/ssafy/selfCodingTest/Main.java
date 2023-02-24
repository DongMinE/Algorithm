package com.ssafy.selfCodingTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static int M, A, path1[], path2[], ans;
	static UserPos up1, up2;
	static Ap[] ap;
	static int[] dr = {0, -1, 0, 1, 0};
	static int[] dc = {0, 0, 1, 0, -1};
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/swea_5644.txt"));

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			M = sc.nextInt();
			A = sc.nextInt();
			path1 = new int[M+1];
			path2 = new int[M+1];
			for (int i = 1; i <= M; i++) {
				path1[i] = sc.nextInt();
			}
			for (int i = 1; i <= M; i++) {
				path2[i] = sc.nextInt();
			}
			ap = new Ap[A];
			for (int i = 0; i < A; i++) {
				ap[i] = new Ap(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
			}
			up1 = new UserPos(1,1);
			up2 = new UserPos(10,10);
			
			solve();
			System.out.printf("#%d %d\n", tc+1, ans);
			ans = 0;
		}
		
		
	}

	private static void solve() {
		for (int i = 0; i < M+1; i++) {
			up1.x += dr[path1[i]];
			up1.y += dc[path1[i]];
			up2.x += dr[path2[i]];
			up2.y += dc[path2[i]];
			charge();
		}
	}

	private static void charge() {
		int max = 0;
		for (int a = 0; a < A; a++) {
			for (int b = 0; b < A; b++) {
				int sum = 0;
				int asum = chargeMax(a, up1);
				int bsum = chargeMax(b, up2);
				if (a != b) sum = asum + bsum;
				else sum = Math.max(asum, bsum);
				if (sum > max) max = sum;
				
			}
		}
		ans += max;
	}

	private static int chargeMax(int idx, UserPos up) {
		return Math.abs(ap[idx].r - up.x) + Math.abs(ap[idx].c - up.y) <= ap[idx].C ? ap[idx].P : 0;
		
	}
	
}

class UserPos {
	int x, y;
	UserPos (int x, int y) {
	this.x = x;
	this.y = y;
	}
}

class Ap {
	int r,c,C,P;
	Ap(int c, int r, int C, int P){
		this.r = r;
		this.c = c;
		this.C = C;
		this.P = P;
	}
}