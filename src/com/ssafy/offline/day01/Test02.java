package com.ssafy.offline.day01;

public class Test02 {
	public static void main(String[] args) {
		System.out.println("반복");
		solve1(10);
		
		System.out.println("재귀");
		solve2(1, 10);

		
	}
	private static void solve1(int num) {
		for (int i = 1; i <= num; i++) {
			System.out.println(i);
		}
	}
	private static void solve2(int start, int num) {
		if(start <= num) {
			return;
		}
		System.out.println(start);
		solve2(start+1,num);		
		
	}

}
