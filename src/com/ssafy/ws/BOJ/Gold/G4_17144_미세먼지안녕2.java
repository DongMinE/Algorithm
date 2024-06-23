package com.ssafy.ws.BOJ.Gold;

import java.util.*;
import java.io.*;

public class G4_17144_미세먼지안녕2 {

    static int R, C, T, cleanUpx, cleanDownx, remainDust;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};

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
                        cleanDownx = i;
                    }
                }
            }
        }
        start(0);
    }

    private static void start(int cnt) {
        if (cnt == T) {
            countDust(map);
            System.out.println(remainDust);
            return;
        }
        int[][] newMap = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    int dust = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dr[k];
                        int ny = j + dc[k];
                        if (nx >= 0 && ny >= 0 && nx < R && ny < C && map[nx][ny] >= 0) {
                            newMap[nx][ny] += map[i][j] / 5;
                            dust += map[i][j] / 5;
                        }
                    }
                    map[i][j] -= dust;
                }
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != -1) {
                    map[i][j] += newMap[i][j];
                }
            }
        }
        //위
        for (int i = cleanUpx - 1; i > 0; i--) {
            map[i][0] = map[i - 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            map[0][i] = map[0][i + 1];
        }
        for (int i = 0; i < cleanUpx; i++) {
            map[i][C - 1] = map[i + 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            map[cleanUpx][i] = map[cleanUpx][i - 1];
        }
        map[cleanUpx][1] = 0;
        //아래
        for (int i = cleanDownx + 1; i < R - 1; i++) {
            map[i][0] = map[i + 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            map[R - 1][i] = map[R - 1][i + 1];
        }
        for (int i = R - 1; i > cleanDownx; i--) {
            map[i][C - 1] = map[i - 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            map[cleanDownx][i] = map[cleanDownx][i - 1];
        }
        map[cleanDownx][1] = 0;

        start(cnt + 1);
    }

    private static void countDust(int[][] newMap) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (newMap[i][j] > 0) {
                    remainDust += newMap[i][j];
                }
            }
        }
    }
}
