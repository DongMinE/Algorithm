package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_1003_피보나치함수 {

    static Integer[][] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        //[n]0]은 0의 개수, [n][1]은 1의 개수
        list = new Integer[41][2];
        list[0][0] = 1;
        list[0][1] = 0;
        list[1][0] = 0;
        list[1][1] = 1;

        while (T --> 0) {
            int num = Integer.parseInt(br.readLine());
            fibo(num);
            sb.append(list[num][0]).append(" ").append(list[num][1]).append("\n");
        }
        System.out.println(sb);
    }
    private static Integer[] fibo(int num) {
        if (list[num][0] == null || list[num][1] == null) {
//            list[num][0] = list[num-1][0] + list[num-2][0];
//            list[num][1] = list[num-1][1] + list[num-2][1];

            list[num][0] = fibo(num-2)[0] + fibo(num-1)[0];
            list[num][1] = fibo(num-2)[1] + fibo(num-1)[1];

        }

        return list[num];
    }
}
