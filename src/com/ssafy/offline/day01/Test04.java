package com.ssafy.offline.day01;

public class Test04 {
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 7};
		System.out.println(solve(0, arr, 0));
	}

	private static int solve(int length, int[] arr, int sum) {
		if (length >= arr.length) return sum;
		
		return solve(length+1, arr, sum+arr[length]);
		
	}

}

