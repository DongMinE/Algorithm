package com.ssafy.ws.BOJ.Gold;

import java.util.Scanner;

public class G4_11404_플로이드 {
	static int inf = 9999999;
	static int N, distance[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int T = sc.nextInt();
		distance = new int[N+1][N+1];
		for (int i = 0; i < T; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int hevy = sc.nextInt();
			// 길이 여러개면 적은 가중치로
			if (distance[start][end] != 0 && distance[start][end] < hevy) continue;
				distance[start][end] = hevy;
		}
		//아직 갈 수 없는 길
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++ ) {
				if (i != j && distance[i][j] == 0) distance[i][j] = inf;
				
			}
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (i == k)
					continue; // 출발지와 경유지가 같다면 다음 출발지
				for (int j = 1; j <= N; j++) {
					if (i == j || k == j)
						continue; //  경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
					if (distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
		}
		
		//1부터 출력
		for (int i = 1; i <= N; ++i) {
			for (int j = 1; j <= N; ++j) {
				if (i != j && distance[i][j] == inf) distance[i][j] = 0;
				System.out.print(distance[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
