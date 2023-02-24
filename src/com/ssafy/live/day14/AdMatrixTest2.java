package com.ssafy.live.day14;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AdMatrixTest2 {
	static class Node{
		int vertex;
		Node link;
		int weight; // 가중치가 있다면
		
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
		
		
	}
	
	static Node[] adjMatrix;
	static int V;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int E = sc.nextInt();
		
		adjMatrix = new Node[V]; //head가 모두 null인 상태
		StringTokenizer st = null;
		int from,to;
		for (int  i = 0; i < E; ++i) {
			from = sc.nextInt();
			to = sc.nextInt();
			// 무향그래프
			adjMatrix[from] = new Node(to, adjMatrix[from]);
			adjMatrix[to] = new Node(from, adjMatrix[to]);
		}
		//bfs(0);
		dfs(0, new boolean[V]);
	}
	
	private static void dfs(int current, boolean[] visited) {
		visited[current] = true;
		System.out.println((char) (current + 65));
		
		for (Node temp = adjMatrix[current]; temp != null; temp = temp.link) {
			if (!visited[temp.vertex]) {
				dfs(temp.vertex, visited);
			}
		}
	}
	
	private static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visit = new boolean[V];
		
		queue.offer(start);
		visit[start] = true;
		
		int current = 0;
		while (!queue.isEmpty()) {
			current = queue.poll();
			System.out.println((char)(current+65));
			
			for (Node temp = adjMatrix[current]; temp != null; temp = temp.link) {
				if (!visit[temp.vertex]) {
					queue.offer(temp.vertex);
				visit[temp.vertex] = true;
				}
			}
		}
	}

}
