package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S4_18110_solvedac {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        int avgNum = (int) Math.round(N * 0.15);

        Arrays.sort(list);
        double sum = 0;
        for (int i = avgNum; i < N - avgNum; i++) {
            sum += list[i];
        }
        System.out.println((int) Math.round(sum / (N - (2 * avgNum))));

    }
}
