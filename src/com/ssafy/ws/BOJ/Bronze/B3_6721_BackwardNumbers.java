package com.ssafy.ws.BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3_6721_BackwardNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringTokenizer st;
        String a, b;
        int sum;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            sb = new StringBuilder(arr[0]);
            a = sb.reverse().toString();
            sb = new StringBuilder(arr[1]);
            b = sb.reverse().toString();
            sum = Integer.parseInt(a) + Integer.parseInt(b);
            String res = Integer.toString(sum);
            sb = new StringBuilder(res);
            System.out.println(Integer.parseInt(sb.reverse().toString()));

        }
    }
}
