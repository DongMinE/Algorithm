package com.ssafy.supply.For3th;

public class Recursive08 {
	
	static int idx;
	public static void main(String[] args) {
		int[] arr = {0};
		recursive(idx,arr );
		
		System.out.println(idx);
		System.out.println(arr[0]);
	}

	private static int recursive(int ix, int[] ar) {
		idx = ix+ 100;
		ar[0]= 100;
		return ix;
	}
	
}
