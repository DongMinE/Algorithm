package com.ssafy.ws.SWEA.CompetencyTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_5644_무선충전 {
	static int M, A;
	static int[] Pa, Pb;
	static int[][] chargePoint;
	static int[][] drx = new int[][] { { 0, 0 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/swea5644.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 총 이동 거리
			A = Integer.parseInt(st.nextToken()); // 충전기 갯수
			chargePoint = new int[A + 1][4]; // 충전기 위치x, 위치y, 가능거리, 1회 양
			Pa = new int[M]; // A이동 정보
			Pb = new int[M]; // B이동 정보

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				Pa[i] = Integer.parseInt(st.nextToken());
				//2 2 3 2 2 2 2 3 3 4 4 3 2 2 3 3 3 2 2 3
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				Pb[i] = Integer.parseInt(st.nextToken());
				//4 4 1 4 4 1 4 4 1 1 1 4 1 4 3 3 3 3 3 3

			}
			for (int i = 1; i <= A; i++) {
				st = new StringTokenizer(br.readLine());
				chargePoint[i][1] = Integer.parseInt(st.nextToken()); // x좌표
				chargePoint[i][0] = Integer.parseInt(st.nextToken()); // y좌표
				chargePoint[i][2] = Integer.parseInt(st.nextToken()); // 가능거리
				chargePoint[i][3] = Integer.parseInt(st.nextToken()); // 1회 충전량

			}

			move(0,0,9,9);

			// print();
		}
	}

	private static void move(int x1, int y1, int x2, int y2) {
		for (int i = 0; i < M; i++) {
			Pa[i] = d1;
			Pb[i] = d2;
			if () 
		}
	}

	private static void print() {
		System.out.println(Arrays.toString(Pa));
		System.out.println(Arrays.toString(Pb));
		System.out.println(Arrays.deepToString(chargePoint));
	}

	// 이동하기(몇번이나 이동함?)

	// 충전 가능한 범위 안에 사람이 있는가? - 있으면 충전

	// 충전할 사람이 1명? 2명? - 2명이면 나눠야해

	// 충전 범위가 다른 충전 범위와 겹치는가 - 겹치면 따로 1개씩 충전 or 1개로 P/2 충전

	// 거리값 계산해 주는 메소드
	
}

//좌표 저장
class Point {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}