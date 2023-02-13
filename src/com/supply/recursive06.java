package com.supply;

import java.util.Arrays;

public class recursive06 {
	static int[] input = {1,3,5};
	static int[] number;
	static boolean[] select;
	public static void main(String[] args) {
		number = new int[2];
		select = new boolean[input.length];
		
		comb(0, 0);
	}
	
	private static void comb(int idx,int cnt) {
		if (cnt == number.length) {
			System.out.println(Arrays.toString(number));
			return;
		}
		for (int i = idx; i < input.length; i++ ) {
			number[cnt] = input[i];
			comb(i+1, cnt+1);
		}

		
	}
}
