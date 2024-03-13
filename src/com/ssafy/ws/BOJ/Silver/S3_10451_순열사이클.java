package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class S3_10451_순열사이클 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            boolean[] check = new boolean[n + 1];
            int[] list = new int[n + 1];
            int cnt = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= n; i++) {
                if (!check[i]) {
                    check[i] = true;
                    int next = list[i];

                    while (true) {
                        if (check[next]) {
                            cnt++;
                            break;
                        }
                        check[next] = true;
                        next = list[next];
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
