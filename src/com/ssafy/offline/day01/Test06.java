package com.ssafy.offline.day01;

public class Test06 {
	static int res = 1;
	
	public static void main(String[] args) {
		System.out.println(factorial1(5));
		factorial2(5);
		System.out.println(res);
		System.out.println(factorial3(5, 1));
		System.out.println(factorial4(5));
	}
	
	private static int factorial4(int n) {
		if (n == 1) return 1;
		return n* factorial4(n-1);
		
	}
	
	private static int factorial3(int n, int ans) {

		if (n == 0) return ans;
		
		if (n > 0) ans *= n;
		
		return factorial3((n-1), ans);
	}	
	
	private static void factorial2(int n) {
		if (n == 0) return;
		
		res *= n;
		factorial2((n-1));
	}	
	
	private static int factorial1(int n) {
		int res = 1;
		for (int i = n; i > 0; i--) {
			res *= i;
		}
		return res;
	}

}
