package com.ssafy.live.day04;

import java.util.Scanner;

public class SubTest {
	static int n;
	static int[] inputs;
	static boolean[] isSelected;
	static int totalCnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		inputs = new int[n];
		isSelected = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			inputs[i] = sc.nextInt();
			
		}
			gererateSubSet(0);
			System.out.println("총 경우의 수: "+totalCnt);
	}
	
	private static void gererateSubSet(int cnt) {
		
		if (cnt == n) {
			totalCnt++;
			for(int i = 0; i <n; i++) {
				System.out.print((isSelected[i]?inputs[i]: "X")+"\t");
			}
			System.out.println();
			return;
		}
		
		
		//현재 원소를 부분집합의 구성에 포함
		isSelected[cnt] = true;
		gererateSubSet(cnt+1);
		
		//현재 원소를 부분집합의 구성에 비포함
		isSelected[cnt] = false;
		gererateSubSet(cnt+1);
		
		
		
	}
	
	

}
