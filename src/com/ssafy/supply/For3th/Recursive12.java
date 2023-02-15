package com.ssafy.supply.For3th;

import java.util.Arrays;

public class Recursive12 {
	static int[] arr = {1,3,5};
	static boolean[] sel = new boolean[arr.length];
	public static void main(String[] args) {
		
		recursive(0,0,sel);
	}

	private static void recursive(int idx, int k, boolean[] sel) {
		
		if (idx == arr.length) {
			//System.out.println(Arrays.toString(sel));
			//if (k==2) { // 이거 없애 부분조합, 있으면 조합 
			for (int i = 0; i < sel.length; i++) {
				if(sel[i]==true) {
					System.out.print("true : " + arr[i]+ " ");
				}
//				else {
//					System.out.print("false : " + arr[i] + " ");
//				}
//			}
			}
			System.out.println();
			return;
		}
		
		sel[idx] = true;
		recursive(idx+1, k+1,sel);
		sel[idx] = false;
		recursive(idx+1, k, sel);
	}
}
