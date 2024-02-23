package com.ssafy.ws.BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class S5_5430_AC {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        //테스트케이스
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayDeque<Integer> deque;
        for (int i = 0; i < T; i++) {
            //명령어
            String oper = br.readLine();
            //원본배열
            int listLength = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), ",[]");
            deque = new ArrayDeque<>();

            //원본 배열 덱큐에 삽입
            for (int j = 0; j < listLength; j++) {
                int input = Integer.parseInt(st.nextToken());
                deque.add(input);
            }
            AC(oper, deque);
        }

        System.out.println(sb);
    }

    private static void AC(String oper, ArrayDeque<Integer> deque) {
        boolean isRight = false;
        for (char cmd : oper.toCharArray()) {
            if (cmd == 'R') {
                isRight = !isRight;
                continue;
            }

            if (isRight) {
                if (deque.pollLast() == null) {
                    sb.append("error\n");
                    return;
                }
            } else {
                if (deque.poll() == null) {
                    sb.append("error\n");
                    return;
                }
            }
        }

        //에러가 아니라면 덱큐의 배열 출력
        sb.append("[");
        if (deque.size() > 0) {
            if (isRight) {
                sb.append(deque.pollLast());

                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            } else {
                sb.append(deque.poll());

                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.poll());
                }
            }
        }
        sb.append("]").append("\n");
    }
}
