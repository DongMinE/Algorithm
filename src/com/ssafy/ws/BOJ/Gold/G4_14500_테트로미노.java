package com.ssafy.ws.BOJ.Gold;

import java.io.*;
import java.util.*;

public class G4_14500_테트로미노 {

    static int n, m, res;
    static int[][] list;
    static boolean[][] check;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new int[n][m];
        check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                check[i][j] = true;
                bfs(i, j, list[i][j], 1);
                check[i][j] = false;
            }
        }

        System.out.println(res);
    }


    private static void bfs(int i, int j, int sum, int cnt) {
        if (cnt == 4) {
            res = Math.max(sum, res);
            return;
        }
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (!check[nx][ny]) {

                    if (cnt == 2) {
                        check[nx][ny] = true;
                        bfs(i, j, sum + list[nx][ny], cnt + 1);
                        check[nx][ny] = false;
                    }

                    check[nx][ny] = true;
                    bfs(nx, ny, sum + list[nx][ny], cnt + 1);
                    check[nx][ny] = false;
                }
            }
        }
    }

}
