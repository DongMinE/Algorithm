package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_2167_2차원배열의합 {
    static int n, m;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
//      배열 받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        System.out.println(Arrays.deepToString(arr));
//        부분 합 계산할 갯수
        int K = Integer.parseInt(br.readLine());
        int[] sumarr = new int[4];
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            for (int q = 0; q < 4; q++) {
                sumarr[q] = Integer.parseInt(st.nextToken());
            }
            System.out.println(Arrays.toString(sumarr));
        }

    }
}