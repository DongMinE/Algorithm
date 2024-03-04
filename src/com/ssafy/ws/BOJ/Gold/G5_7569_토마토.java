package com.ssafy.ws.BOJ.Gold;

import java.io.*;
import java.util.*;

public class G5_7569_토마토 {

    public static void main(String[] args) throws IOException {
        int[] rz = {0, 0, 0, 0, 1, -1};
        int[] ry = {0, 0, 1, -1, 0, 0};
        int[] rx = {1, -1, 0, 0, 0, 0};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] tomato = new int[h][n][m];
        Queue<Location> goodTomato = new ArrayDeque<>();
        int res = 0;
        int notTomato = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    int input = Integer.parseInt(st.nextToken());
                    tomato[i][j][k] = input;
                    if (input == 0) {
                        notTomato++;
                    } else if (input == 1) {
                        goodTomato.add(new Location(i, j, k));
                    }
                }
            }
        }

        while (!goodTomato.isEmpty() && notTomato > 0) {
            int size = goodTomato.size();

            for (int i = 0; i < size; i++) {
                Location output = goodTomato.poll();
                int z = output.z;
                int y = output.y;
                int x = output.x;

                for (int j = 0; j < 6; j++) {
                    int nz = z + rz[j];
                    int ny = y + ry[j];
                    int nx = x + rx[j];

                    if (nz < 0 || nz >= h || ny < 0 || ny >= n || nx < 0 || nx >= m) {
                        continue;
                    } else if (tomato[nz][ny][nx] != 0) {
                        continue;
                    }

                    notTomato--;
                    tomato[nz][ny][nx] = 1;
                    goodTomato.add(new Location(nz, ny, nx));
                }
            }
            res++;
        }

        System.out.println(notTomato == 0 ? res : -1);
    }
}

class Location {

    int x;
    int y;
    int z;

    Location(int z, int y, int x) {
        this.z = z;
        this.y = y;
        this.x = x;
    }
}