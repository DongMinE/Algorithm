package com.ssafy.ws.BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class G4_17141_연구소2 {
	static int N, M, arr[][], Vpos[];
	static List<int[]> virus;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 연구실 구조
		arr = new int[N][N];
		// 바이러스 놓을 장소 저장 리스트
		virus = new ArrayList<int[]>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				// 2면 위치값 저장하기
				if (num == 2) {
					arr[i][j] = 0;
					virus.add(new int[] { i, j });
				} else {
					arr[i][j] = num;
				}
			}
		}
		for (int[] a : arr) System.out.println(Arrays.toString(a));
		System.out.println("--------------------------");
		for (int[] a : virus) System.out.println(Arrays.toString(a));

		//comb(0);
	}

	private static void comb(int cnt) {
		int[] combNum = new int[M];
		if (cnt == M) {
			int[][] copyarr = arr.clone();
			bfs();
		}

	}

	private static void bfs() {

	}
}
