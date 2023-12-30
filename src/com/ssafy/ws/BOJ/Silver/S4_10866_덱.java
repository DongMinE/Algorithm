package com.ssafy.ws.BOJ.Silver;

import java.io.*;
import java.util.*;


public class S4_10866_덱 {

    static Deque<Integer> q;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        q = new LinkedList<>();
        sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();

            switch (oper) {
                case "push_front":
                    q.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    q.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if (q.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(q.poll()).append("\n");
                    }
                    break;
                case "pop_back":
                    if (q.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(q.pollLast()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    if (q.isEmpty()) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                case "front":
                    if (q.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(q.peekFirst()).append("\n");
                    }
                    break;
                case "back":
                    if (q.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(q.peekLast()).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
