package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_11660_구간합구하기5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int[][] dp = new int[n + 1][n + 1];
        int x1, x2, y1, y2 = 0;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken()) + dp[i][j - 1];
            }
        }
//        System.out.println(Arrays.deepToString(dp));

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            int res = 0;

            for (int j = x1; j <= x2; j++) {
                res += dp[j][y2] - dp[j][y1 - 1];
            }
            sb.append(res + "\n");
        }
        System.out.print(sb);
    }
}
