package com.ssafy.offline.day02;

import java.util.Arrays;
import java.util.Scanner;

public class 아침순열 {
	static int N, R;
	static boolean[] visited;
	static int[] numbers, input;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		visited = new boolean[N];
		numbers = new int[R];
		input = new int[N];
		
		for (int i = 0; i < N; i++) input[i] = sc.nextInt();
		
		perm(0);
	}

	private static void perm(int cnt) {
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 0; i < N; i++) {
			//if (visited[i]) continue;
			
			//visited[i] = true;
			numbers[cnt] = input[i];
			perm(cnt+1);
			//visited[i] = false;
		}
	}

	
	
}
