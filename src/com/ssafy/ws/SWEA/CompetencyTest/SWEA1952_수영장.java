package com.ssafy.ws.SWEA.CompetencyTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA1952_수영장 {
	static int T, N;
	static int Ans = Integer.MAX_VALUE;
	static int[] fee = new int[4];
	static int[] month = new int[12];
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("수영장.txt"));
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			Ans = Integer.MAX_VALUE;
			for (int i = 0; i < fee.length; i++) {
				fee[i]=sc.nextInt();
			}
			for (int i = 0; i < month.length; i++) {
				month[i]=sc.nextInt();
			}
			
			recursive(0,0);
			//System.out.println(Arrays.toString(month));
			System.out.printf("#%d %d\n",tc, Ans);
		}
		
	}
	private static void recursive(int idx, int sum) {
		// basis part
		if(idx>=12) {
			Ans = Math.min(Ans, sum);
			return;
		}
		
		
		// inductive part
		// 1일 이용권
		recursive(idx+1, sum+month[idx]*fee[0]);
		// 1달 이용권
		recursive(idx+1, sum+fee[1]);
		// 3달 이용권
		recursive(idx+3, sum+fee[2]);
		// 1년 이용권
		recursive(idx+12, sum+fee[3]);
	}
	
}