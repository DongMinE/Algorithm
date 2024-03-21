package com.ssafy.ws.BOJ.Silver;

import java.io.*;
import java.util.*;

public class S2_21736_헌내기는친구가필요해 {

    static int n, m, a, b, res;
    static char[][] list;
    static boolean[][] check;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new char[n][m];
        check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String cha = br.readLine();
            for (int j = 0; j < m; j++) {
                list[i][j] = cha.charAt(j);
                if (cha.charAt(j) == 'I') {
                    a = i;
                    b = j;
                } else if (cha.charAt(j) == 'X') {
                    check[i][j] = true;
                }
            }
        }
        bfs();

        if (res == 0) {
            System.out.println("TT");
        } else {
            System.out.println(res);

        }
    }

    private static void bfs() {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{a, b});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (list[nx][ny] == 'O' && !check[nx][ny]) {
                        check[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    } else if (list[nx][ny] == 'P' && !check[nx][ny]) {
                        res++;
                        check[nx][ny] = true;
                        q.add(new int[]{nx, ny});
//                        System.out.println(nx + " " + ny);
                    }
                }
            }
        }
    }
}
