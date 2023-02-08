package com.ssafy.offline.day01;

public class Test03 {
	public static void main(String[] args) {
		System.out.println("반복 : " + solve1(10));
		
		System.out.println("재귀 : " + solve2(1, 10, 0));
		
	}

	private static int solve1(int num) {
		int sum = 0;
		for (int i = 1; i <= num; i++) {
			sum += i;
		}
		return sum;

	}
	
	private static int solve2(int start, int end, int sum) {
		if (start > end) return sum;
		
		return solve2(start+1, end, sum+start);
	}

}
