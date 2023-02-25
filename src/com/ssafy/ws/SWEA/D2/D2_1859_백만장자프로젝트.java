package com.ssafy.ws.SWEA.D2;

import java.util.Arrays;
import java.util.Scanner;

public class D2_1859_백만장자프로젝트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int day = sc.nextInt();
			int[] arr = new int[day];
			for (int i = 0; i < day; i++) {
				arr[i] = sc.nextInt();
			}
			int money = 0;
			int max = arr[day-1];
			for (int i = day-1; i >= 0; i--) {
				max = Math.max(max, arr[i]);
				if (max > arr[i]) money += max - arr[i];
			}
			System.out.println(money);
		}
	}
}
