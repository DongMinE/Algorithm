package com.ssafy.ws.BOJ.Silver;

import java.io.*;
import java.util.*;

public class S4_10845_큐 {

    static Queue<Integer> q;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        q = new LinkedList<>();
        StringTokenizer st;
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();
            if (oper.equals("push")) {
                push(Integer.parseInt(st.nextToken()));
            } else if (oper.equals("pop")) {
                pop();
            } else if (oper.equals("size")) {
                size();
            } else if (oper.equals("empty")) {
                empty();
            } else if (oper.equals("front")) {
                front();
            } else if (oper.equals("back")) {
                back();
            }
        }
        System.out.println(sb);
    }

    private static void push(int x) {
        q.add(x);
    }

    private static void pop() {
        if (q.isEmpty()) {
            sb.append("-1\n");
        } else {
            sb.append(q.remove()).append("\n");
        }
    }

    private static void size() {
        sb.append(q.size()).append("\n");
    }

    private static void empty() {
        if (q.isEmpty()) {
            sb.append("1\n");
        } else {
            sb.append("0\n");
        }
    }

    private static void front() {
        if (q.isEmpty()) {
            sb.append("-1\n");
        } else {
            sb.append(q.peek()).append("\n");
        }
    }

    private static void back() {
        if (q.isEmpty()) {
            sb.append("-1\n");
        } else {
            int size = q.size();
            for (int i = 0; i < size - 1; i++) {
                q.add(q.remove());
            }
            sb.append(q.peek()).append("\n");
            q.add(q.remove());
        }
    }
}
