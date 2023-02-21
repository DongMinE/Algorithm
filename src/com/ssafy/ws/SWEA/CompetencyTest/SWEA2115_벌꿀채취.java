package com.ssafy.ws.SWEA.CompetencyTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA2115_벌꿀채취 {
	// N 벌통의 크기 3 <= N <=10
	// M 벌통의 개수 1 <= M <= 5
	// 꿀 채취 최대 양 10 <= C <= 30
	static int N,M,C, arr[][];
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/swea2115.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {				
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
		}
		//for (int[] v : arr) System.out.println(Arrays.toString(v));
	}

}
