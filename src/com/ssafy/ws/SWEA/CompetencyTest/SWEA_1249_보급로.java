package com.ssafy.ws.SWEA.CompetencyTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_1249_보급로 {
	static int[][] map;
	static int size, min;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			size = Integer.parseInt(br.readLine());
			map = new int[size][];
			for (int i = 0; i < size; i++) map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
			//System.out.println(Arrays.deepToString(map));
		
			
			System.out.print("#" + tc + " ");
			System.out.println(start());
		}
	}
	private static int start() {
		boolean[][] visit = new boolean[size][size];
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		pq.offer(new Pos(0,0,0));
		visit[0][0] = true;
		
		while (!pq.isEmpty()) {
			Pos current = pq.poll();
			if (current.x == size-1 && current.y == size-1)
				return current.time;
		
			for (int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < size && ny < size && !visit[nx][ny]) {
					visit[nx][ny] = true;
					pq.offer(new Pos(nx, ny,current.time + map[nx][ny]));
				}
			}
		}
		return 0;
	}
	
	private static class Pos implements Comparable<Pos> {
		int x, y;
		int time;
		
		Pos(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}
		@Override
		public int compareTo(Pos o) {
			return this.time - o.time;
		}
	}
	
	

}
