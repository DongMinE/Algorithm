package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_2615_오목 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] arr = new int[19][19];
		int[][] dir = { { 0, 1 }, { 1, 0 }, { 1, 1 }, { -1, 1 } };

		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		for (int[] a : arr) System.out.println(Arrays.toString(a));
		
		// ??? 왜 j를 먼저 돌려야 제일 왼쪽꺼가 나오는 거임???
		for (int j = 0; j < 19; j++) {
			for (int i = 0; i < 19; i++) {
				if (arr[i][j] == 1 || arr[i][j] == 2) {
					for (int k = 0; k < 4; k++) {
						int x = i;
						int y = j;
						int cnt = 1;
						
						// 오목 완성인지 보기
						while (true) {
							x += dir[k][0];
							y += dir[k][1];
							if (x < 19 && y < 19 && x >= 0 && y >= 0) {
								if (arr[x][y] == arr[i][j])
									cnt++;
								else break;

							} else break;
						}
						x = i;
						y = j;
						
						// 위에엇 += 했으면 5개 면 답이고 아니면 아닌거지 왜 또 빼줘야함 ㅡㅡ
						// 현재 시간 새벽 2시 나는 생각하기를 멈추었다. 넘 졸리다.
						// 내일 교수님한테 여쭤봐야겠다. 후후... 똑똑한 나...
						while (true) {
							x -= dir[k][0];
							y -= dir[k][1];
							if (x < 19 && y < 19 && x >= 0 && y >= 0) {
								if (arr[x][y] == arr[i][j])
									cnt++;
								else break;

							} else break;
						}
						if(cnt == 5) {
							System.out.println(arr[i][j]);
							System.out.println((i+1) + " " + (j+1));
							return;
						}
					}
				}
			}
		}
		System.out.println(0);
	}
}
