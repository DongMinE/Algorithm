package com.ssafy.ws.BOJ.Silver;

import java.util.Arrays;
import java.util.Scanner;

public class S2_1182_부분수열의합 {
	static int N, num, arr[], res;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		num = sc.nextInt();

		arr = new int[N]; // 입력 배열
		visited = new boolean[N]; // 방문 처리

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		subset(0); //왜 부분집합 재귀로 안됨!!!!!
		//dfs(0, 0);
		
		//답의 합이 0을 구해야 할 때 아무것도 더하지 않았을 때 0도 답에 인정돼서 -1?
		if (num == 0)
			System.out.println(res - 1);
		else
			System.out.println(res);
	}

//	private static void dfs(int cnt, int sum) {
//		if (cnt == N) {
//			if (sum == num) res++;
//			return;
//		}
//		dfs(cnt+1, sum+arr[cnt]);
//		dfs(cnt+1, sum);
//	}

	private static void subset(int cnt) {
		if (cnt == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (!visited[i]) continue;
				sum += arr[i];
				//System.out.print(arr[i] + " ");
			}
			if (sum == num) res++;
			//System.out.println("sum의 합: "+sum);
			return;
		}
		visited[cnt] = true;
		subset(cnt+1);
		visited[cnt] = false;
		subset(cnt+1);
	}
	

}
