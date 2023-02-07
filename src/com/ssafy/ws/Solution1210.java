package com.ssafy.ws;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution1210 {
	static String arr[][];

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		arr = new String[100][100];
		int idx = 0;
		for (int t = 1; t <= 10; t++) {
			for (int i = 0; i < 100; i++) {
				arr[i] = sc.nextLine().split(" ");
			}
			for (int j = 0; j < 100; j++) {
				if (arr[99][j] == "2")idx = j;
					
			}

			System.out.println(idx);
		}
	}

}
