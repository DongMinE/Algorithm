package com.ssafy.ws.BOJ.Silver;

import java.io.*;
import java.util.*;

public class S4_11047_동전0 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] money = new int[n];
        int cnt = 0;

        for (int i = n - 1; i >= 0; i--) {
            money[i] = Integer.parseInt(br.readLine());
        }
//        System.out.println(Arrays.toString(money));

        for (int i = 0; i < money.length; i++) {
            if (money[i] <= k) {
                cnt += (k / money[i]);
                k %= money[i];
            }
        }
        System.out.println(cnt);
    }
}
