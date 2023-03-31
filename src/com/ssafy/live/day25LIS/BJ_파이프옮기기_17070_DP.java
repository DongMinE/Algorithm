package com.ssafy.live.day25LIS;

import java.util.Scanner;

public class BJ_파이프옮기기_17070_DP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		for(int i = 0; i < N; i++) for(int j = 0; j < N; j++) map[i][j] = sc.nextInt();

		long[][][] D = new long[N][N][3];
		D[0][1][0] = 1;
		
		for (int i = 2; i < N; i++) if (map[0][i] == 0) D[0][i][0] = D[0][i-1][0];

		for(int i = 1; i < N; i++) {
			for(int j = 2; j < N; j++) {
				if(map[i][j] != 0) continue;
				
				D[i][j][0] += D[i][j-1][0] + D[i][j-1][2];
				D[i][j][1] += D[i-1][j][1] + D[i-1][j][2];

				if(map[i-1][j] == 0 && map[i][j-1] == 0)
					D[i][j][2] += D[i-1][j-1][0] + D[i-1][j-1][1] + D[i-1][j-1][2];
			}
		}
		System.out.println(D[N-1][N-1][0] + D[N-1][N-1][1] + D[N-1][N-1][2]);
	}
}
