package com.ssafy.ws.BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_14502_연구소 {

    static int[][] list;
    static ArrayList<int[]> zero;
    static int shall = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

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
        comb();
    }

    private static void comb() {

    }
}
