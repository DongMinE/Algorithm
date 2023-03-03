package com.ssafy.ws.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_17144_미세먼지안녕 {

	static int R, C, T, res, cleanUpx, cleanDownx, remainDust;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static int[] upr = {0, -1, 0 , 1}, upc = {1, 0, -1, 0};
	static int[] downr = {0, 1, 0, -1}, downc = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if (num == -1) {
					if (cleanUpx == 0) {
						cleanUpx = i+1;
					} else {
						cleanDownx = i;
					}
				}
			}
		}
		//start(0);
		System.out.println(cleanUpx + " " + cleanDownx);
		
	}

	// cnt가 T가 될 때까지 재귀 돌려
	private static void start(int cnt) {
		// T초 되면 멈춰
		if (cnt == T) {
			// 먼지 몇개나 있나 세고 리턴
			countDust(map);
			System.out.println(remainDust);
			return;
		}
		// 1초후 먼지 퍼짐
		//퍼진 먼지만 따로 모아서 배열에 넣어주고 다 퍼지고 난 뒤에 퍼지고 남은 먼지+다른 곳에서 들어온 먼지 해줄꺼임
		int[][] newMap = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// 0먼지를 만나면 4방향으로 퍼짐
				if (map[i][j] > 0) {
					// 배열 한개마다 퍼질 먼지 0으로 초기화
					int dustOne = 0;
					for (int d = 0; d < 4; d++) {
						int ni = i + dr[d];
						int nj = j + dc[d];
						if (ni >= 0 && nj >= 0 && ni < R && nj < C && map[ni][nj] >= 0) {
							//새 배열에 퍼진 먼지 저장했다가
							newMap[ni][nj] += map[i][j] / 5;
							//퍼진만큼 저장해주고
							dustOne += map[i][j] / 5;
						}
					}
					//4방향 다 퍼지면 빼주고
					map[i][j] -= dustOne;
				}
			}
		}
		//다 돈다음에 퍼졌던 것들 더해줌
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != -1)
				map[i][j] += newMap[i][j];
			}

		}
		// 잘 출력됐나 확인
		for (int k = 0; k < R; k++) {
			System.out.println(Arrays.toString(map[k]));
		}
		System.out.println();
		
		
		// 1초후 공기정청기 돔
		//위 순환
		for (int i = 0+1; i < cleanUpx; i++) {
			for (int j = 0; j < C; j++) {
				
			}
		}
		//아래 순환
		for (int i = cleanDownx+1; i < R; i++) {
			for (int j = 0; j < C; j++) {
				
			}
		}
		
		
		
		start(cnt + 1);
	}

	private static void countDust(int[][] newMap) {
		remainDust = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (newMap[i][j] > 0)
					remainDust += newMap[i][j];
			}
		}
	}
}
