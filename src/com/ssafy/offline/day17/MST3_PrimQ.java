package com.ssafy.offline.day17;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MST3_PrimQ {
	static class Vertex implements Comparable<Vertex> {
		int no, cost;
		Vertex(int no, int cost) {
			this.no = no;
			this.cost = cost;
		}
		@Override
		public int compareTo(Vertex o) {
//			return Integer.compare(this.cost, o.cost);
			return this.cost - o.cost;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner("7\r\n" + 
				"0 32 31 0 0 60 51\r\n" + 
				"32 0 21 0 0 0 0\r\n" + 
				"31 21 0 0 46 0 25\r\n" + 
				"0 0 0 0 34 18 0\r\n" + 
				"0 0 46 34 0 40 51\r\n" + 
				"60 0 0 18 40 0 0\r\n" + 
				"51 0 25 0 51 0 0");
		int N = sc.nextInt();
		
		int[][] data = new int[N][N];
		// 니편 내편 인지 판단
		boolean[] visited = new boolean[N];
		// 각 정점에 연결할 때 최소의 비용
		int[] minCost = new int[N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				data[i][j] = sc.nextInt();
			}
		}
		
		// 최대 비용으로 초기값 설정 : 정점의 최소 비용 보관을 위해 최대값으로 설정
		Arrays.fill(minCost, Integer.MAX_VALUE);
		
		// 시작정점 세팅
		minCost[0] = 0;
		int ans = 0;  // 최소신장트리의 간선의 비용을 담을 변수
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(0, 0));
		int cnt = 0;
		// VlogV + ElogV -> 
		// SWEA-D4-최소 스패닝 트리(3124)
		// V : 100000, E : 200000
		// K       : O[ElogE + E] -> 200000log200000 + 200000 : 360만
		// Prim    : O[2V2]		  -> 200억
		// Prim PQ : O[(V + E)logV]
		while (!pq.isEmpty()) {
			Vertex minVertex = pq.poll();
			if (visited[minVertex.no]) continue;
			
			// 이제 내편으로 (최소신장트리에 포함되었다)
			visited[minVertex.no] = true;
			ans += minVertex.cost;
			
			if (++cnt == N) break;
			
			// 선택된 정점에 대해서 연결된 간선들의 비용과 최소비용을 가지고 있는 minCost와 비교해서 최소 비용 갱신작업
			for (int i = 0; i < N; i++) {
				if (!visited[i] && data[minVertex.no][i] != 0 
						&& minCost[i] > data[minVertex.no][i]) {
					minCost[i] = data[minVertex.no][i];
					pq.offer(new Vertex(i, data[minVertex.no][i]));
				}
			}
		}
		System.out.println(ans);
	}
}





