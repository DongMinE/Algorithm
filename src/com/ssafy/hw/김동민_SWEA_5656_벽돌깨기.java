package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 김동민_SWEA_5656_벽돌깨기 {
	static int N, W, H, res;
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
            res = Integer.MAX_VALUE;
            start(0, total, map);
            System.out.println("#" + tc + " " + res);
		}
	}

	private static boolean start(int cnt, int remainBlock, int[][] map) {
		// 남은 벽돌 개수 확인
		if (remainBlock == 0) {
			res = 0;
			//남은 벽돌이 하나도 없다면 더이상 안해도 됨.
			return true;
		}
		// 구슬 다 던지면?
		if (cnt == N) {
			// 최소값 비교해주고 작은거 던짐
			res = Math.min(res, remainBlock);
			// 다른 경우도 있을 수도 있으니까 false
			return false;
		}
		
		int[][] newMap = new int[H][W];
		//구슬은 위에서부터 떨어지니까 맨 위부터 부셔야함
		//for문을 r부터가 아닌 c로 시작해서 1,0 2,0 3,0오로 봐야함
		for (int c = 0; c < W; c++) {
			
			int r = 0;
			// 0은 계속 넘어가야함 한줄 다보면 다음 줄(++c)되서 또 보고 반복
			while(r < H && map[r][c] == 0) ++r;
			//벽돌이 없을 경우 다음
			if (r == H) continue;
			
			//벽돌 만나면 일단 현재 배열 복사
			copy(map, newMap);
			//벽돌 몇개 부수는지 복사배열이랑 해당 블럭 좌표 던짐
			int burstCnt = burst(newMap, r, c);
			//벽돌 내리기
			down(newMap);
			//다음 구슬 처리할껀데 더이상 확인할 필요 없으면 true
			if (start(cnt + 1, remainBlock - burstCnt, newMap)) return true;
		}
		return false;
	}

	private static void down(int[][] map) {
		for (int c = 0; c < W; c++) {
			int r = H-1;
			while(r > 0) {
				if (map[r][c] == 0) {
					int nr = r -1;
					while (nr > 0 && map[nr][c] == 0) nr--;
					
					map[r][c] = map[nr][c];
					map[nr][c] = 0;
				}
				r--;
			}
				
		}
	}
	
	// 벽돌 부수는 기능을 bfs queue로 구현하면 터치면서 다른 연쇄작용가능한 벽돌을 만나면
	// 또 큐 들어가서 큐 빌 때까지 터침
	private static int burst(int[][]map, int r, int c) {
		int cnt = 0;
		Queue<State> q = new LinkedList<>();
		//블록이 1보다 크면 연쇄로 더져야 하니까 큐에 넣음
		if (map[r][c] > 1) q.add(new State(r,c,map[r][c]));
		//1이던가 1보다 크던가 일단 0으로 만들어 주는건 동일
		map[r][c] = 0;
		cnt++;
		
		while(!q.isEmpty()) {
			State now = q.poll();
			
			//4방향으로 구슬숫자 -1만큼 터침
			for (int d = 0; d < 4; d++) {
				int rr = now.r;
				int cc = now.c;
				for (int k = 0; k < now.cnt -1; k++) {
					rr += dr[d];
					cc += dc[d];
					if (rr < 0 || cc < 0 || rr >= H || cc >= W || map[rr][cc] == 0) continue;
					if (map[rr][cc] > 1) q.add(new State(rr, cc, map[rr][cc]));
					
					map[rr][cc] = 0;
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static void copy(int[][] map, int[][] newMap) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}

	
	
}
