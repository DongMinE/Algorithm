package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.StringTokenizer;

public class S1_21218_피아노체조 {
    static int[] arr, sum;
    static int N, Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //입력값
        StringTokenizer st = new StringTokenizer(br.readLine()); // 악보 배열
        arr = new int[N + 1];
        sum = new int[N + 1];
        for (int i = 1; i < N + 1; i++) { // 1부터 배열에 넣음
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i - 1] > arr[i]) {
                sum[i] += sum[i - 1] + 1;
            } else {
                sum[i] = sum[i - 1];
            }
        }
        Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(sum[y] - sum[x]).append("\n");
        }
            System.out.println(sb);
    }

}
