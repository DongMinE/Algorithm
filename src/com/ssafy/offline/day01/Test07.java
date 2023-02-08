package com.ssafy.offline.day01;

public class Test07 {
	public static void main(String[] args) {
		int n = 4;
		int k = 3;
		System.out.println(comb(n, k));
	}

	private static int comb(int n, int k) {
		if (n == k || k == 0) return 1;
		
		
		return comb(n-1, k-1) + comb(n-1, k);
	}

}
