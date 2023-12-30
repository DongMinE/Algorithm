package com.ssafy.ws.BOJ.Silver;

import java.io.*;
import java.util.*;

public class S5_11866_요세푸스문제0 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int people = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            q.add(i);
            list.add(i);
        }
        sb.append("<");

//        while (q.size() > 1) {
//            // 방법1. 빼려는 숫자만큼 앞에 숫자를 뒤로 보내고 맨 앞에 있는 숫자 제거
//            for (int j = 0; j < people - 1; j++) {
//                q.offer(q.poll());
//            }
//            sb.append(q.poll()).append(", ");
//        }

        // 방법2. 건너뛰는 숫자 -1 만큼 현재 idx에 더하고 큐의 크기 만큼 나눈 나머지값의 위치 제거
        int idx = 0;
        while (N > 1) {
            idx = (idx + (people - 1)) % N;
            sb.append(list.remove(idx)).append(", ");
            N--;
        }
//        sb.append(q.poll()).append(">");
        sb.append(list.remove()).append(">");
        System.out.println(sb);

    }
}
