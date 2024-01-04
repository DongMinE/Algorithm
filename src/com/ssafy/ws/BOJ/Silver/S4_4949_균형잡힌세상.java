package com.ssafy.ws.BOJ.Silver;

import java.io.*;
import java.util.*;

public class S4_4949_균형잡힌세상 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;

        while (true) {

            str = br.readLine();

            if (str.equals(".")) {
                break;
            }
            sb.append(sol(str)).append("\n");

        }
        System.out.println(sb);
    }

    private static String sol(String str) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char cha = str.charAt(i);
            if (cha == '(' || cha == '[') {
                stack.push(cha);
            } else if (cha == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return "no";
                } else {
                    stack.pop();
                }
            } else if (cha == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return "no";
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()) {
            return "yes";
        } else {
            return "no";
        }
    }
}
