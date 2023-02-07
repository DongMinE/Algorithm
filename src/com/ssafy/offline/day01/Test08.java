package com.ssafy.offline.day01;

public class Test08 {
	static long[] memo;
	static int cnt1, cnt2;
	
	public static void main(String[] args) {
		
		int N = 40;
		memo = new long[N+1];
		memo[0] = 0;
		memo[1] = 1;
		System.out.println(fibo1(N));
		System.out.println(cnt1);
		System.out.println(fibo2(N));
		System.out.println(cnt2);
	}

	private static long fibo1(int n) {
		++cnt1;
		if (n < 2) return n;
		return fibo1(n - 1) + fibo1(n - 2);
	}
	
	private static long fibo2(int n) {
		++cnt2;
		if (n >= 2 && memo[n] == 0) {
			memo[n] = fibo2(n-1) + fibo2(n-2);
		}
			return memo[n];
	}


}
