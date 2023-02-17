package com.ssafy.ws.BOJ;

import java.util.Scanner;

public class S1_16935_배열돌리기3 {
	static int[][] map;
	static int N, M, R;
	static Scanner sc = new Scanner("6 8 1\r\n" + 
			"3 2 6 3 1 2 9 7\r\n" + 
			"9 7 8 2 1 4 5 3\r\n" + 
			"5 9 2 1 9 6 1 8\r\n" + 
			"2 1 3 8 6 3 9 2\r\n" + 
			"1 3 2 8 7 9 2 1\r\n" + 
			"4 5 1 9 8 2 1 3\r\n" + 
			"5");
//	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		N = sc.nextInt(); // 행
		M = sc.nextInt(); // 열
		R = sc.nextInt(); // 연산수
		inputMap();
		// 연산 처리하기
		solve();
		// 연산된 결과 출력
		printMap();
	}

	private static void inputMap() {
		map = new int[N][M];
		for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) map[i][j] = sc.nextInt();
	}

	static void solve() {
		for (int i = 0; i < R; i++) {
			switch (sc.nextInt()) {
			case 1: method1(); break;
			case 2: method2(); break;
			case 3: method3(); break;
			case 4: method4(); break;
			case 5: method5(); break;
			case 6: method6(); break;
			}
		}
	}

	static void method1() {
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M; j++) {
				int temp = map[i][j];
				map[i][j] = map[N - i - 1][j];
				map[N - i - 1][j] = temp; 
			}
		}
	}
	
	static void method2() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				int temp = map[i][j];
				map[i][j] = map[i][M - j - 1];
				map[i][M - j - 1] = temp; 
			}
		}
	}

	static void method3() {
		int[][] temp = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = map[N - j - 1][i];
			}
		}
		map = temp;
		N = M;
		M = map[0].length;
	}

	static void method4() {
		for (int i = 0; i < 3; i++) method3();
		/*
		int[][] temp = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = map[j][M - i - 1];
			}
		}
		map = temp;
		N = M;
		M = map[0].length;
		*/
	}

	static void method5() {
		int[][] temp = new int[N][M];
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				temp[i][j + M / 2] = map[i][j];  				// 2 - 1
				temp[i + N / 2][j + M / 2] = map[i][j + M / 2]; // 3 - 2
				temp[i + N / 2][j] = map[i + N / 2][j + M / 2]; // 4 - 3
				temp[i][j] = map[i + N / 2][j];					// 1 - 4
			}
		}
		map = temp;
	}

	static void method6() {
		for (int i = 0; i < 3; i++) method5();
		/*
		int[][] temp = new int[N][M];
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				temp[i][j] = map[i][j + M / 2];					// 1 - 2
				temp[i][j + M / 2] = map[i + N / 2][j + M / 2]; // 2 - 3
				temp[i + N / 2][j + M / 2] = map[i + N / 2][j]; // 3 - 4
				temp[i + N / 2][j] = map[i][j];					// 4 - 1
			}
		}
		map = temp;
		*/
	}

	static void printMap() {
		for (int i = 0; i < map.length; i++) { 
			for (int j = 0; j < map[i].length; j++) 
				System.out.print(map[i][j] + " ");
			System.out.println();
		}
	}
}
