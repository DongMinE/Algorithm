package com.ssafy.ws.BOJ.Gold;

import java.io.*;
import java.util.*;

public class G3_1238_파티 {

    static int[][] list;
    static int n, m, x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        list = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j) {
                    list[i][j] = 0;
                } else {
                    list[i][j] = 1000000000;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[from][to] = cost;
        }

        System.out.println(Arrays.deepToString(list));

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (list[i][k] + list[k][j] < list[i][j]) {
                        list[i][j] = list[i][k] + list[k][j];
                    }
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            if (res < list[i][x] + list[x][i]) {
                res = list[i][x] + list[x][i];
            }
        }
        System.out.println(res);
    }

}
