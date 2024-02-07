package com.ssafy.ws.BOJ.Silver;

import java.io.*;
import java.util.*;

public class S3_9095_123더하기 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[12];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 0; i < n; i++) {
            for (int j = 4; j < 12; j++) {
                dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
            }
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }
    }
}
