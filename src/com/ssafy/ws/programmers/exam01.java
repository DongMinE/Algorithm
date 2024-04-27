package com.ssafy.ws.programmers;

import java.io.*;
import java.util.*;

public class exam01 {

    public static void main(String[] args) throws IOException {
        int[] arr = new int[]{1, 1, 3, 3, 0, 1, 1};

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.add(arr[i]);
            } else {
                int top = stack.peek();

                if (top != arr[i]) {
                    stack.add(arr[i]);
                }
            }
        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        System.out.println(Arrays.toString(res));
//        for (int a : stack) {
//            System.out.println("1" + a);
//        }
    }
}