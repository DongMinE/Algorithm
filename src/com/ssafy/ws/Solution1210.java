package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1210 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[100][100];
		int idx = 0;
		
		for (int t = 1; t <= 10; t++) {
			int T = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());

					if (arr[i][j] == 2) {
						idx = j;
					}
				}

			}

			int start = 98;
			boolean left = true;
			boolean right = true;
			while (true) {
				// 맨위 까찌 올라옴
				if (start == 0)
					break;
				// 왼쪽길 가능
				if (idx > 0) {
					if (arr[start][idx-1] == 1 && left) {
						idx--;
						right = false;
						continue;
					}
				}
				// 오른쪽길 가능
				if (idx < 99) {
					if (arr[start][idx+1] == 1 && right) {
						idx++;
						left = false;
						continue;
					}
				}
				start--;
				left = true;
				right = true;
			}
			System.out.printf("#%d %d\n", t, idx);
		}
	}
	
}
