package com.ssafy.offline.day17;

import java.util.Arrays;
import java.util.Scanner;

public class MST2_Prim {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] data = new int[N][N];
		//니편 내편 판단
		boolean[] visited = new boolean[N];
		
		// 각 정점에 연결할 때 최소의 비용
		int[] minCost = new int[N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				data[i][j] = sc.nextInt();
			}
		}
		
		//정점의 최소 비용을 보관하기 위해 최대값으로 설정
		Arrays.fill(minCost, Integer.MAX_VALUE);
		
		// 시작 정점 세팅
		minCost[0] = 0;
		int ans = 0; // 최소 신장트리의 간선의 비용을 담을 변수
		for (int n = 0; n < N; n++) {
			int min = Integer.MAX_VALUE, minVertex = -1;
			for (int i = 0; i < N; i++) {
				if (!visited[i] && min > minCost[i]) {
					min = minCost[i];
					minVertex = i;
				}
			}
			// 이제 내편으로 (최소신장트리에 포함되었다.)
			visited[minVertex] = true;
			ans += min;
			
			//선택된 정덤에 대해서 연결된 간선들의 비용과 최소비용을 가지고 있는 minCost와 비교해서 최소비용을 갱신
			for (int i = 0; i < N; i++) {
				if (!visited[i] && data[minVertex][i] != 0 
						&& minCost[i] > data[minVertex][i]) {
					minCost[i] = data[minVertex][i];
				}
			}
		}
		System.out.println(ans);
	}

}
