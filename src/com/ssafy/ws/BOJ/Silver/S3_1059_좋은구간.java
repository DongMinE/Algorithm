package com.ssafy.ws.BOJ.Silver;

import java.io.*;
import java.util.*;

public class S3_1059_좋은구간 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        int high = 1001;
        int row = 0;
        int res = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < l; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num < n) {
                if (num > row) {
                    row = num;
                }
            } else if (num > n) {
                if (num < high) {
                    high = num;
                }
            } else {
                System.out.println(0);
                return;
            }
        }
        for (int i = row + 1; i <= n; i++) {
            for (int j = n; j < high; j++) {
                if (i != j) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
