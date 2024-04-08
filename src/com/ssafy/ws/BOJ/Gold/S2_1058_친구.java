package com.ssafy.ws.BOJ.Gold;

import java.io.*;
import java.util.*;

public class S2_1058_친구 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        String arr[] = in.readLine().split(" ");
        int ans[] = new int[arr.length];
        for (int i = arr.length - 1, j = 0; i >= 0; i--, j++) {
            int cnt = Integer.parseInt(arr[i]);
            if (cnt == j) {
                ans[j] = i + 1;
            } else {
                for (int k = j; k > cnt; k--) {
                    ans[k] = ans[k - 1];
                }
                ans[cnt] = i + 1;
            }
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}