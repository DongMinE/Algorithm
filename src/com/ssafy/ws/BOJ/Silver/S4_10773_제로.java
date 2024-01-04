package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class S4_10773_제로 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> list = new Stack<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                list.add(num);
            } else {
                list.pop();
            }
//            System.out.println(list);
        }
        int sum = 0;
        for (int j : list) {
            sum += j;
        }
        System.out.println(sum);
    }
}
