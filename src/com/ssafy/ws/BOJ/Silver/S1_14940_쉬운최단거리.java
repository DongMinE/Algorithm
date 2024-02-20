package com.ssafy.ws.BOJ.Silver;

import java.io.*;
import java.util.*;

public class S1_14940_쉬운최단거리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] list = new int[n][m];
        int[][] res = new int[n][m];
        int[] start = new int[2];
        boolean[][] visit = new boolean[n][m];
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

//        Queue<int[]> q = new ArrayDeque<>();
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int inputNumber = Integer.parseInt(st.nextToken());
                list[i][j] = inputNumber;
                if (inputNumber == 2) {
                    start[0] = i;
                    start[1] = j;
                } else if (inputNumber == 0) {
                    visit[i][j] = true;
                }
            }
        }
        // 시작 지점 삽입
        q.add(new int[]{start[0], start[1]});
        visit[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            int[] current = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = current[0] + dx[i];
                int y = current[1] + dy[i];
                if (x >= 0 && x < n && y >= 0 && y < m) {
                    if (list[x][y] == 1 && !visit[x][y]) {
                        visit[x][y] = true;
                        res[x][y] = res[current[0]][current[1]] + 1;
                        q.add(new int[]{x, y});
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j]) {
                    res[i][j] = -1;
                }
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
