package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class S2_1874_스택수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int start = 0;
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());

            if (val > start) {
                for (int j = start + 1; j <= val; j++) {
                    stack.push(j);
                    sb.append("+").append("\n");
                }
                start = val;
            }

            if (stack.peek() != val) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append("-").append("\n");
        }
        System.out.println(sb);
    }

}