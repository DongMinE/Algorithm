package com.ssafy.ws.BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_14502_연구소 {

    static int[][] list;
    static boolean[] check;
    static ArrayList<int[]> zero;
    static int[][] virus = new int[3][2];
    static int shall = 0;
    static int n, m;
    static int[] nr = new int[]{0, 0, 1, -1};
    static int[] nx = new int[]{-1, 1, 0, -0};
    static Queue<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 원본배열
        list = new int[n][m];
        // 0이 담긴 좌표 배열
        zero = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
                if (list[i][j] == 0) {
                    zero.add(new int[]{i, j});
                }
            }
        }
        check = new boolean[zero.size()];

        comb(0, 0);
    }

    private static void comb(int idx, int cnt) {
        if (cnt == 3) {
            //정해진 위치 3개를 갖고 바이러스 퍼지기 시작
            spread(virus);
        } else {
            for (int i = idx; i < zero.size(); i++) {
                virus[cnt] = zero.get(i);
                comb(i + 1, cnt + 1);
            }
        }
    }

    // 바이러스 퍼뜨려
    private static void spread(int[][] virus) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (list[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];

        }
    }
}
