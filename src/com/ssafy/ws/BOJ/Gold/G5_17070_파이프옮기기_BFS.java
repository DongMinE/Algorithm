package com.ssafy.ws.BOJ.Gold;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class G5_17070_파이프옮기기_BFS {
    static int[][] map;
    static int N, ans;
    static class Pos {
    	int r, c, dir;
		public Pos(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        map = new int[N][N];
        for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) map[i][j] = sc.nextInt();

        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(0, 1, 0));

        int ans = 0;
        while (!q.isEmpty()) {
        	Pos cur = q.poll();
            int r = cur.r, c = cur.c, dir = cur.dir;
            if (r + 1 == N && c + 1 == N) {
                ans++;
                continue;
            }

            if (dir != 1 && c + 1 < N && map[r][c + 1] != 1) q.add(new Pos(r, c + 1, 0));
    		if (dir != 0 && r + 1 < N && map[r + 1][c] != 1) q.add(new Pos (r + 1, c, 1));
    		if (r + 1 < N && c + 1 < N && map[r + 1][c + 1] != 1 && map[r][c + 1] != 1 && map[r + 1][c] != 1) q.add(new Pos(r + 1, c + 1, 2));
        }
        System.out.println(ans);
    }
}