package com.ssafy.offline.day15;

import java.util.Arrays;
import java.util.Scanner;

public class 서로소집합 {
	static int N;
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = 5;
		p = new int[N];

		// 집합 생성
		// make - 집합 생성
		makeSet();
		System.out.println(Arrays.toString(p));
		
		// union - 집합 합치기
		System.out.println(union(3, 4));
		System.out.println(Arrays.toString(p));
		System.out.println(union(3, 4));
		System.out.println(Arrays.toString(p));
		System.out.println(union(0, 4));
		System.out.println(Arrays.toString(p));
	}

//	private static void union(int a, int b) {
//		//a집합의 대표 찾기
//		int aRoot = find(a);
//		//b집합의 대표 찾기
//		int bRoot = find(b);
//		p[bRoot] = aRoot;
//		
//	}
	private static boolean union(int a, int b) {
		// a집합의 대표 찾기
		int aRoot = find(a);
		// b집합의 대표 찾기
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;

		p[bRoot] = aRoot;
		return true;

	}

	private static int find(int a) {
		if (p[a] == a)
			return a;

		return p[a] = find(p[a]);
	}

	private static void makeSet() {
		for (int i = 0; i < N; i++) {
			p[i] = i;
		}

	}

}
