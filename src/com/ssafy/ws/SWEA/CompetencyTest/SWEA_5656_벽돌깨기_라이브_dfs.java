package com.ssafy.ws.SWEA.CompetencyTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_5656_벽돌깨기_라이브_dfs {
	static int N, W, H, min;
	static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
	
	static class State {
		int r, c, cnt;

		//좌표랑 구슬 cnt
		public State(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 쏠 수 있는 구슬 개수
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            
            int total = 0; // 벽돌 개수
            int[][] map = new int[H][W];
            for (int r = 0; r < H; r++) {
            	st = new StringTokenizer(br.readLine());
            	
            	for (int c= 0; c < W; c++) {
            		map[r][c] = Integer.parseInt(st.nextToken());
            		if (map[r][c] > 0) total++;
            	}
            }
            //제일 적은 벽돌이 남아야하니까 max로 초기화
            min = Integer.MAX_VALUE;
            go(0, map);
            System.out.println("#" + tc + " " + min);
		}
	}

	private static boolean go(int cnt, int[][] map) {
		
		//벽돌 개수 파일
		int result = getRemain(map);
		if (result == 0) {
			min = 0;
			return true;
		}
			
		if(cnt == N) {
			if (min > result) min = result;
			return false;
		}
		
		int[][] newMap = new int[H][W];
		//모든 열에 구슬 던지기
		for (int c = 0; c < W; c++) {
			
			// 처음 맞는 벽돌(위에서)
			int r = 0;
			while (r < H && map[r][c] == 0) ++r;
			
			if (r == H) continue;
			
			//배열 원본으로 초기화
			copy(map, newMap);
			//벽돌 부수기
			boom(newMap, r, c, newMap[r][c]);
			//벽돌 내리기
			down(newMap);
			//다음 구슬던지기
			if(go(cnt + 1, newMap)) return true;
		}
		
		return false;
		
	}
	
	private static Stack<Integer> stack = new Stack<>();
	private static void down(int[][] map) {
		//각 열에 대해 윗행부터 아래행까지 벽돌만 스택에 넣어두고 아래행부터 채우기
		for (int c = 0; c < W; c++) {
			for (int r = 0; r < H; r++) {
				if (map[r][c] > 0) {
					stack.push(map[r][c]);
					map[r][c] = 0;
				}
			}
			
			int r = H - 1;
			while(!stack.isEmpty()) {
				map[r--][c] = stack.pop();
			}
		}
		
	}
	private static void boom(int[][] map, int r, int c, int cnt) {
		map[r][c] = 0;
		if (cnt == 1) return;
			
		// 현벽돌cnt-1만큼 4방
		for (int d = 0; d < 4; d++) {
			int nr = r;
			int nc = c;
			for (int k = 1; k <= cnt - 1; k++) {
				nr += dr[d];
				nc += dc[d];
				if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] > 0) {
						boom(map, nr, nc, map[nr][nc]);
				}
			}

		}
	}

	private static int getRemain(int[][] map) {
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] > 0) count++;
			}
		}
		return count;
	}

	private static void copy(int[][] map, int[][] newMap) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}

	

	
	
}
