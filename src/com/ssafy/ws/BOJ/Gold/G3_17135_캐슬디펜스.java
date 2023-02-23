package com.ssafy.ws.BOJ.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G3_17135_캐슬디펜스 {
	static int n, m, d;
	static int[][] map;
	static int[][] copy;
	static int count;
	static int max = Integer.MIN_VALUE;
	static ArrayList<int[]> bow; // 활잡이 위치 들어간배열(3명분의 x,y위치값)
	static boolean[] archer; // 활잡이 위치들어간 배열 만들어 주기위한 M크기의 배열 ex) 11100
	static int min_dist, min_x, min_y;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		map = new int[n][m]; // 게임할 배열
		copy = new int[n][m]; // 게임한번 하고 다시 원복하기 위한 배열

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				copy[i][j] = map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		archer = new boolean[m];
		comb(0, 0);

		System.out.println(max);
	}

	public static void comb(int start, int cnt) {
		// 활잽이 3명 채우면 활잽이 위치 들어갈 리스트
		if (cnt == 3) {
			bow = new ArrayList<>();
			// System.out.println(Arrays.toString(archer));
			/*
			 * [true, true, true, false, false] 
			 * [true, true, false, true, false] 
			 * [true, true, false, false, true] 
			 * [true, false, true, true, false] 
			 * [true, false,true, false, true] 
			 * [true, false, false, true, true] 
			 * [false, true, true, true, false]
			 * [false, true, true, false, true] 
			 * [false, true, false, true, true]
			 * [false, false, true, true, true]
			 */
			for (int i = 0; i < m; i++) {
				if (archer[i]) {
					bow.add(new int[] { n, i }); // 활잡이 위치 추가
				}
			}
			attack();
			return;
		}

		for (int i = start; i < m; i++) {
			if (archer[i])
				continue;
			archer[i] = true; // 활잽이가 있는 경우
			comb(i + 1, cnt + 1);
			archer[i] = false; // 없는 경우
		}
	}

	public static void attack() {
		count = 0; // 마릿수

		// n만큼 적이 내려오면 끝
		for (int t = 0; t < n; t++) {
			//동시에 공격해야 하니까 바로 안죽이고 체크할 배열
			boolean[][] kill = new boolean[n][m];

			// 각 궁수별로 최소 거리에 있는 적 구하기
			for (int i = 0; i < 3; i++) {
				//현재 활잽이의 x,y 위치 가져옴
				int cur[] = bow.get(i);
				System.out.println(Arrays.toString(cur));
				min_dist = Integer.MAX_VALUE; // 최소 거리
				min_x = Integer.MAX_VALUE; // 최소 거리에 있는 몬스터의 x좌표
				min_y = Integer.MAX_VALUE; // 최소 거리에 있는 몬스터의 y좌표

				for (int j = 0; j < n; j++) {
					for (int k = 0; k < m; k++) {
						if (map[j][k] == 1) {
							int dist = dist(j, cur[0], k, cur[1]);
							if (min_dist >= dist) {
								if (min_dist > dist) {
									// 최소 거리가 작으면 가까운거 부터 사냥
									min_dist = dist; // 최소거리 변경
									min_x = k; // 최소 거리의 x
									min_y = j; // 최소 거리의 y
								} else {
									if (min_x > k) {
										// 거리가 같다면 가장 왼쪽 사냥
										min_x = k; // 최소 거리의 x
										min_y = j; // 최소 거리의 y
									}
								}
							}
						}
					}
				}

				// 몬스터를 구했다면 해당 몬스터를 공격해야함
				if (min_dist <= d) {
					kill[min_y][min_x] = true;
				}
				// 여기서 바로 0으로 만들지 않고 true로만 처리해줌
				// 처리해버리면 뒤에 활잽이가 똑같은 적을 공격할 수 도 있는데 그 경우를 없애버림
			}

			// 활잽이 3마리 다 돌리면
			// 방문된 곳 = 공격할 곳인거 공격
			// 공격한 것 = 처리한 것의 카운트 증가
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (kill[i][j]) {
						map[i][j] = 0;
						count++;
					}
				}
			}

			// 성 바로 위에 있는 것 처리
			for (int i = 0; i < m; i++) {
				map[n - 1][i] = 0;
			}

			// 적들 한 칸씩 전진
			for (int i = n - 1; i >= 1; i--) {
				for (int j = 0; j < m; j++) {
					map[i][j] = map[i - 1][j];
				}
			}

			// 맨 위에 있는 것 처리
			for (int i = 0; i < m; i++) {
				map[0][i] = 0;
			}

			// 가장 많이 처리한 경우로 값 변경
			max = Math.max(max, count);
		}

		// 맵 초기화
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = copy[i][j];
			}
		}
	}

	// 거리 구하기
	public static int dist(int x1, int x2, int y1, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}
