package com.ssafy.Off01;

public class Test05 {
	public static void main(String[] args) {

		int[] arr = {1,3,5,7,9};
		// search 함수를 재귀를 이용하여 구현
		// 3- > 1 반환
		// 4 -> -1 빈횐

		System.out.println(solve(0, arr, 3));
		System.out.println(solve(0, arr, 4));
		
		
		
	}

	private static int solve(int idx, int[] arr, int searchNum) {
		if (idx >= arr.length) return -1;
		
		if (arr[idx] == searchNum) return 1;
		
		return solve(idx+1,arr, searchNum);
		
		
	}

}
