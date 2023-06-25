package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_18222_투에모스문자열 {
    static long[] arr = new long[64];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (long)Math.pow(2,i);
        }
        System.out.println(sol(k));

    }

    private static int sol(long k) {
        if (k == 1) return 0;

        long first = 0;

        for (int i = 0; i < arr.length; i++) {
            if (k > arr[i]) first = arr[i];
            else break;
        }
        return 1 - sol(k - first);
    }
}

//            0110 1001 1001 0110
//            1001 0110 0110 1001
//            1001 0110 0110 1001
