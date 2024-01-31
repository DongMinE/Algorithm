package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class S3_2579_계단오르기 {

    static int[] maxList, list;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        maxList = new int[n + 1];
        list = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int input = Integer.parseInt(br.readLine());
            list[i] = input;
        }
        maxList[1] = list[1];
        maxList[2] = list[2] + list[1];
        maxList[3] = Math.max(list[1], list[2]) + list[3];

        for (int i = 4; i <= n; i++) {
            maxList[i] = Math.max(maxList[i - 2], maxList[i - 3] + list[i - 1]) + list[i];
        }
        System.out.println(maxList[n]);
    }
}
