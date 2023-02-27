package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_2567_색종이2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[][] white = new int[102][102]; 
		int N = Integer.parseInt(st.nextToken()); 
		int res = 0;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()); 
			int x = Integer.parseInt(st.nextToken());
			int cnt = 0;
			for (int i = x + 1; i <= x + 10; i++) {
				for (int j = y + 1; j <= y + 10; j++) {
					white[i][j] = 1; 
				}
			}
			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, -1, -1 };
			for (int i = 0; i < 102; i++) {
				for (int j = 0; j < 102; j++) {
					if (white[i][j] == 1) {
						for (int k = 0; k < 4; k++) {
							int ix = i + dr[k];
							int jy = j + dc[k];
							if (white[ix][jy] == 0)
								cnt++;
						}
					}
				}
			}
			res = cnt;
		}
		System.out.println(res);
	}
}
