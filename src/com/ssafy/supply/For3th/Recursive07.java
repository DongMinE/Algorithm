package com.ssafy.supply.For3th;

import java.util.Arrays;

public class Recursive07 {
	static int[] arr = {1,3,5,7,9};
	static boolean[] check = new boolean[arr.length];
	public static void main(String[] args) {
		recursive(0,0, new int[2]);
	}

	private static void recursive(int idx, int k, int[] sel) {
		if (k==sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		
//		sel[k] = 0;
//		recursive(k+1, sel);
//		
//		sel[k] = 1;
//		recursive(k+1, sel);
//		
//		sel[k] = 2;
//		recursive(k+1, sel);
		
		for (int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			recursive(i, k+1, sel);
			
			
			
//			check[i] = true;
//			sel[k] = arr[i];
//			recursive(k+1,sel);
//			check[i] = false;
		}
	}

}
