package com.ssafy.live.day13;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AdjMatrixTest2 {
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
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
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
		print();
	}

	private static void print() {
		for (Node node : adjMatrix) { //node = 각 정점의 인접리스트
			System.out.println(node);
		}
	}
}
