package com.supply;

public class Recursive05 {
	static int[] arr = {1,3,5};
	public static void main(String[] args) {
		recursive(0,1);
	}

	private static void recursive(int i, int value) {
		System.out.println("+++++++++++++++");
		if(i == arr.length) {
			System.out.println(value);
			return;
		}
		
		recursive(i+1, value+arr[i]);
		System.out.println("------------"
				+ "");
		recursive(i+1, value*arr[i]);
	}

}
