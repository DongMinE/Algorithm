package com.ssafy.live.day09;

import java.util.Arrays;
import java.util.Scanner;

//nPn만 가능
public class PermutationNPTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] input = new int[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();

		}
		//제일 먼저 전처리: 오름차순정렬
		//Arrays.sort(input);
		
		do {
			System.out.println(Arrays.toString(input));
			
		}while (np(input));
	}

	private static boolean np(int[] input) {
		int n = input.length;
		
		//stop1. 뒤부터 꼭대기 찾기 (꼭대기 바로 앞이 교환할 자리)
		int i = n-1;
		while(i > 0 && input[i-1] >= input[i]) --i;
		if (i==0) return false;
		System.out.println(Arrays.toString(input));
		
		//step2. 꼭대기 바로 앞(i-1) 자리에 교환할 값을 뒤쪽부터 찾는다.
		int j = n-1;
		while(input[i-1] >= input[j]) j--;
		System.out.println(Arrays.toString(input));
		
		swap(input, i-1, j);
		//step3. 꼭대기 바로 앞(i-1)자리와 그 자리값보다 한단계 큰 자리(i)수와 교환
		int k = n -1;
		while (i<k) {
			swap(input, i++, k--);
		}
		System.out.println(Arrays.toString(input));
		System.out.println("------------------------");
		return true;
	}
		private static void swap(int[] input , int i, int j) {
			int temp = input[i];
			input[i] = input[j];
			input[j] = temp;
		}
}
