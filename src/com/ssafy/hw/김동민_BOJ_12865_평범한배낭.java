package com.ssafy.hw;

import java.util.Arrays;
import java.util.Scanner;

public class 김동민_BOJ_12865_평범한배낭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //총 물건 개수
		int K = sc.nextInt(); //무게 한도
		
		int[] weight = new int[N+1]; //물건들 무게
		int[] funny = new int[N+1]; //물건들 재미
		for (int i = 1; i <= N; i++) {
			weight[i] = sc.nextInt();
			funny[i] = sc.nextInt();
		}
		int[][] D = new int[N+1][K+1];
		
		for (int i = 1; i <= N; i++) { //현재 고려한는 물건
			for (int j = 1; j <= K; j++) { // 현재까지의 무게
				// 지금 물건이 지금 무게를 초과하는가
				if (weight[i] > j) {
					D[i][j] = D[i-1][j];
				}
				else {
					D[i][j] = Math.max(D[i-1][j], funny[i] + D[i-1][j-weight[i]]);
				}
			}
		}
		System.out.println(D[N][K]);
//		System.out.println(Arrays.toString(weight));
//		System.out.println(Arrays.toString(funny));
	}
}
