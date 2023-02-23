package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class S1_2667_단지번호붙이기 {
	static int N, arr[][], apt, cnt, nx, ny;
	static boolean check[][];
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		arr = new int[N][N];
		check = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1 && !check[i][j]) {
					cnt = 0;
					apt++;
					findapt(i, j);
					list.add(cnt);
				}
			}
		}
		Collections.sort(list);;
		System.out.println(apt);
		for (int  v : list) {
			System.out.println(v);
		}
//		for (int[]  v : arr) {
//			System.out.println(Arrays.toString(v));
//		}
	}

	private static void findapt(int x, int y) {
		check[x][y] = true;
		arr[x][y] = apt;
		cnt++;
		for (int i = 0; i < 4; i++) {
			nx = x + dr[i];
			ny = y + dc[i];
			if (nx >=0 && ny >= 0 && nx < N && ny < N && arr[nx][ny] == 1 && !check[nx][ny]) {
					check[nx][ny] = true;
					arr[nx][ny] = apt;
					
					findapt(nx, ny);
				

			}

		}
	}
}
