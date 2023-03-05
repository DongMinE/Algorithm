package com.ssafy.ws.BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_17144_미세먼지안녕 {

	static int R, C, T, res, cleanUpx, cleanDownx, remainDust;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	//static int[] upr = {-1,0,1,0}, upc = {0,1,0,0,-1};
	//static int[] downr = {1,0,-1,0}, downc = {0,1,0,-1};
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
						cleanUpx = i;
					} else {
						cleanDownx = cleanUpx+1;
					}
				}
			}
		}
		start(0);
		//System.out.println(cleanUpx + " " + cleanDownx);
		
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

		// 1초후 공기정청기 돔
		
		//위 순환
		for (int i = cleanUpx -1; i > 0; i--) map[i][0] = map[i-1][0];
		for (int i = 0; i < C-1; i++) map[0][i] = map[0][i+1];
		for (int i = 0;  i < cleanUpx; i++) map[i][C-1] = map[i+1][C-1];
		for (int i = C-1; i > 1; i--) map[cleanUpx][i] = map[cleanUpx][i-1];
		map[cleanUpx][1] = 0;
		//아래 순환
		for (int i = cleanDownx +1; i < R-1; i++) map[i][0] = map[i+1][0];
		for (int i = 0; i < C-1; i++) map[R-1][i] = map[R-1][i+1];
		for (int i = R -1; i > cleanDownx; i--) map[i][C-1] = map[i-1][C-1];
		for (int i = C-1; i > 1; i--) map[cleanDownx][i] = map[cleanDownx][i-1];
		map[cleanDownx][1] = 0;
		
		
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
