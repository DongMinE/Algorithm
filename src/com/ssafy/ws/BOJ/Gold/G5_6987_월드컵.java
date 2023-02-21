package com.ssafy.ws.BOJ.Gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_6987_월드컵 {
	static int Team = 6;
	static int[][] match;
	static boolean endGame;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/TEST.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int size = 0;
		/*
		 * 최대 경기가능 수 15
		 * A - B, C, D, E, F
		 * B - C, D, E, F
		 * C - D, E, F
		 * D - E, F
		 * E - F
		 */
		for (int i = 1; i < Team; i++) {
			size += i;
		}
		//경기별 매치 팀 저장
		match = new int[size][2];

	}

}
