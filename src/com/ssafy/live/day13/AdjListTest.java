package com.ssafy.live.day13;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AdjListTest {
	static int[][] adjMatrix;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		adjMatrix = new int[V][V]; //모두 0인 상태
		StringTokenizer st = null;
		int from,to;
		for (int  i = 0; i < E; ++i) {
			from = sc.nextInt();
			to = sc.nextInt();
			
			//무향
			adjMatrix[to][from] = adjMatrix[from][to] = 1;
			//유향
			//adjMatrix[from][to] = 1;
		}
		print();
	}

	private static void print() {
		for (int[] am: adjMatrix)
			System.out.println(Arrays.toString(am));
	}
}
