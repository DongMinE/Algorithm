package com.ssafy.ws.SWEA.D3;

import java.util.Scanner;

public class Solution1208Fp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int i = 1; i <= 10; i++) {
			int N = sc.nextInt();
			int[] box = new int[101];
			int maxH = 1;
			int minH = 100;
			for (int j = 0; j <100; j++) {
				int h = sc.nextInt();
				box[h]++;
				if (minH > h) minH = h;
				if (maxH < h) maxH = h;
			}
			while(true) {
				if (N <= 0 || maxH - minH <= 1) break;
				
				box[minH]--;
				box[minH + 1]++;
				box[maxH]--;
				box[maxH - 1]++;
				
				if (box[minH] == 0) minH--;
				if (box[maxH] == 0) maxH--;
				
				--N;
			}
			System.out.println(maxH-minH);
		}
	
	}
}
