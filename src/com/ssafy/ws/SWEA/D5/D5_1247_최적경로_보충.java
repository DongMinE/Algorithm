package com.ssafy.ws.SWEA.D5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D5_1247_최적경로_보충 {
	static int T, N;
	static int Ans = Integer.MAX_VALUE;
	static class Point{
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("최적경로.txt"));
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			 Ans = Integer.MAX_VALUE;
			N=sc.nextInt();
			Point company = new Point(sc.nextInt(), sc.nextInt());
			Point home = new Point(sc.nextInt(), sc.nextInt());
			
			Point[] customers = new Point[N];
			for (int i = 0; i < N; i++) {
				customers[i]=new Point(sc.nextInt(), sc.nextInt());
			}
			
			//System.out.println(Arrays.toString(customers));
			recursive(0,customers,new Point[N],new boolean[N],company,home);
			
			System.out.printf("#%d %d\n",tc, Ans);
		}
		
	}
	private static void recursive(int k, Point[] customers
			, Point[] sel, boolean[]v, Point company, Point home) {
		// basis part
		if(k==sel.length) {
			//System.out.println(Arrays.toString(sel));
			// 고객의 집 방문 순서를 순열을 통해 모든 경우의 수를 구했습니다
			// 계산식 |x1-x2| + |y1-y2|
			int c = Math.abs(company.r-sel[0].r) + Math.abs(company.c-sel[0].c); 
			int h = Math.abs(sel[sel.length-1].r - home.r) + Math.abs(sel[sel.length-1].c - home.c);
			int sum = 0;
			for (int i = 0; i < sel.length-1; i++) {
				sum+=Math.abs(sel[i].r-sel[i+1].r)+Math.abs(sel[i].c-sel[i+1].c);
			}
			Ans = Math.min(Ans,c + h + sum);
			return;
		}
		
		// inductive part
		for (int i = 0; i < customers.length; i++) {
			if(!v[i]) {
				v[i]=true;
				//sel[k]=customers[i];
				sel[k]=customers[i];
				recursive(k+1, customers, sel,v,company, home);
				v[i]=false;
			}
		}
	}
	
	
}