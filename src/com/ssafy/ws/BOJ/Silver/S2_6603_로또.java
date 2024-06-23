package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2_6603_로또 {

    static int size, m, cnt;
    static int[] num;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            size = Integer.parseInt(st.nextToken());
            if (size == 0) {
                break;
            }
            num = new int[size];
            check = new boolean[size];

            for (int i = 0; i < size; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            comb(0, 0);
            System.out.println();
        }
    }

    private static void comb(int start, int cnt) {
        if (cnt == 6) {
            for (int i = 0; i < size; i++) {
                if (check[i]) {
                    System.out.print(num[i] + " ");
                }
            }
            System.out.println();
        }
        for (int i = start; i < size; i++) {
            check[i] = true;
            comb(i + 1, cnt + 1);
            check[i] = false;
        }
    }
}
