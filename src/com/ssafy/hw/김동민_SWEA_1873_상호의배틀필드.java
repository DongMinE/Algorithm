package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 김동민_SWEA_1873_상호의배틀필드 {
	static int h, w, x, y, shutx, shuty, movex, movey;
	static char[][] arr;
	static String move;
	static int direction;
	static int[][] d = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상 하 좌 우

	// 처음 바라보는 방향으로 먼저 쏠 방향 설정해주고 대포 쏘고
	// 이동하는 조건 나오면 머리 먼저 돌리고 이동
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/swea1873.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr = new char[h][w];
			direction = 0;
			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				for (int j = 0; j < w; j++) {
					arr[i][j] = str.charAt(j);
					if (arr[i][j] == '^' || arr[i][j] == 'v' || arr[i][j] == '<' || arr[i][j] == '>') {
						if (arr[i][j] == '^')
							direction = 1;
						else if (arr[i][j] == 'v')
							direction = 2;
						else if (arr[i][j] == '<')
							direction = 3;
						else if (arr[i][j] == '>')
							direction = 4;

						x = i;
						y = j;
					}
				}
			}

			int N = Integer.parseInt(br.readLine());
			move = br.readLine();

			for (int i = 0; i < N; i++) {
				char moving = move.charAt(i);
				if (moving == 'U' || moving == 'D' || moving == 'L' || moving == 'R') {
					if (moving == 'U') {
						direction = 1;
						arr[x][y] = '^';
					} else if (moving == 'D') {
						direction = 2;
						arr[x][y] = 'v';
					} else if (moving == 'L') {
						direction = 3;
						arr[x][y] = '<';
					} else if (moving == 'R') {
						direction = 4;
						arr[x][y] = '>';
					}
					movex = x + d[direction][0];
					movey = y + d[direction][1];
					if (movex >= 0 && movey >= 0 && movex < h && movey < w) {
						if (arr[movex][movey] == '.') {
							arr[movex][movey] = arr[x][y];
							arr[x][y] = '.';
							x = movex;
							y = movey;
						}
					}

				} else if (moving == 'S') {
					shutx = x;
					shuty = y;
					while (true) {
						shutx += d[direction][0];
						shuty += d[direction][1];
						if (!(shutx >= 0 && shuty >= 0 && shutx < h && shuty < w) || arr[shutx][shuty] == '#')
							break;
						else if (arr[shutx][shuty] == '*') {
							arr[shutx][shuty] = '.';
							break;
						}
					}
				}
			}

			System.out.print("#" + tc + " ");
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}

//			for (int i = 0; i < h; i++) System.out.println(Arrays.toString(arr[i]));
//			System.out.println(move);
		}
	}

}
