package com.ssafy.ws.BOJ.Gold;

import java.util.Scanner;

public class G5_2023_신기한소수 {
	static int n,m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); 
		int arr[] = {2,3,5,7};
		for (int v : arr) solve(v, n-1);
		
		
		
	}
	private static void solve(int v, int n) {
		if (n==0) {
			System.out.println(v);
			return;
		}
		
		for (int i = 1; i <10; i+=2) {
			int num = 10*v+i;
			if (isprime(num)) {
				solve(num,n-1);
			}
		}
	}
	private static boolean isprime(int num) {
		for (int i = 2; i*i < num; i++) {
			if (num%i == 0) return false;
		}
		return true;
	}
}
