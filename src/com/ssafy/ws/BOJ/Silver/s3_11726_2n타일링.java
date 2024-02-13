package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class s3_11726_2n타일링 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] list = new int[n + 1];
        list[0] = 1;
        list[1] = 1;

        for (int i = 2; i <= n; i++) {
            list[i] = (list[i - 1] + list[i - 2])%10007;
        }

        System.out.println(list[n]);
    }
}
