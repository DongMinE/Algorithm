package com.ssafy.live.day13;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.ssafy.live.day06.Node;

public class AdjMatrixTest {	
	static ArrayList<Integer>[] adjList;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		 
		adjList = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}
		int from,to;
		for (int  i = 0; i < E; ++i) {
			from = sc.nextInt();
			to = sc.nextInt();
			// 무향그래프
			adjList[from].add(to);
			adjList[to].add(from);
		}
		print();
	}

	private static void print() {
		for (ArrayList<Integer> list : adjList) { //node = 각 정점의 인접리스트
			System.out.println(list);
		}
	}
}
