package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_1018_체스판다시칠하기 {
    static boolean[][] arr;
    static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new boolean[n][m];
        //배열 받기
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                //처음 시작이 W라면 true
                if (str.charAt(j) == 'W') {
                    arr[i][j] = true;
                    //처음 시작이 B이라면 false
                } else arr[i][j] = false;
            }
        }
        int nr = n - 7;
        int nc = m - 7;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                solve(i, j);
            }
        }
        System.out.println(min);
    }

    private static void solve(int x, int y) {
        int cnt = 0;
        boolean start = arr[x][y];
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                //다음 값이 옳지 않다면 cnt 증가
                if (arr[i][j] != start) {
                    cnt++;
                }
                //다음 문자 비교 전에 바꿔주기
                start = !start;
            }
            //한 줄 다 읽었으면 바꿔주기
            start = !start;
        }
        //첫번째 색을 기준으로 바꿔야할 개수 vs (반대색을 기준으로 바꿔야할 개수 = 64 - cnt)
        cnt = Math.min(cnt, 64 - cnt);
        //기존의 최소값 vs 현재 8*8의 최소값
        min = Math.min(cnt, min);
    }
}
