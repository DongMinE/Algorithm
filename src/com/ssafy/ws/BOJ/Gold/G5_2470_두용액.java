package com.ssafy.ws.BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_2470_두용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
        int max = Integer.MAX_VALUE;
        int start = 0;
        int end = arr.length - 1;

        int big = 0;
        int small = 0;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (max > Math.abs(sum)) {
                max = Math.abs(sum);
                big = arr[end];
                small = arr[start];
            }
            if (sum > 0) {
                end--;
            } else start++;
        }
        System.out.println(small +" " + big);
    }
}
