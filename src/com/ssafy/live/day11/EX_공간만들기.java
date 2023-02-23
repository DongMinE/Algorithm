package com.ssafy.live.day11;

import java.util.Scanner;
/**
 * @author THKim
 */
public class EX_공간만들기 {
	static int white = 0;
	static int green = 0;
	static int[][] spaces;
	
	// 주어진 영역의 공간의 셀 체크하여 모두 초록색이나 하얀색으로 이루어져있는지 확인 후
	// 4개로 쪼개기.
	// 하얀색 0 , 초록색 1
	static void cut() {

		
		
		
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		spaces = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				spaces[i][j] = sc.nextInt();
			}
		}


		
		
		System.out.println(white);
		System.out.println(green);
		sc.close();
	}
}
