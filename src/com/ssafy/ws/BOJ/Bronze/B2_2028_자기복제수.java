package com.ssafy.ws.BOJ.Bronze;

import java.io.*;
import java.util.*;

public class B2_2028_자기복제수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int nPow = n * n;
            boolean isNo = false;
            while (n != 0) {
                int a = n % 10;
                int b = nPow % 10;
                if (a != b) {
                    sb.append("NO\n");
                    isNo = true;
                    break;
                }
                n /= 10;
                nPow /= 10;
            }
            if (!isNo) {
                sb.append("YES\n");
            }
        }
        System.out.print(sb);
    }
}
