package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S3_1966_프린터큐 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)
        );
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine()); // 배열 갯수랑 찾을려는 토큰

            int num = Integer.parseInt(st.nextToken()); // 갯수
            int findNum = Integer.parseInt(st.nextToken()); // 찾을려는 애

            LinkedList<int[]> list = new LinkedList<>(); // 큐 리스트 (찾을려는 애 비교, 즁요도)
            st = new StringTokenizer(br.readLine()); // 배열 토큰

            // 큐 만들기
            for (int j = 0; j < num; j++) {
                list.offer(new int[]{j, Integer.parseInt(st.nextToken())});
            }
            int cnt = 0;
            // 제일 큰지 비교하기
            while (true) {
                int[] front = list.poll();
                // 제일 큰놈인가 체크
                boolean check = true;

                // 반복 돌려서 front의 중요도 보다 큰 애 있나 검사
                for (int j = 0; j < list.size(); j++) {
                    if (front[1] < list.get(j)[1]) {
                        // 큰애가 존재하면 앞에꺼 다 빼서 맨 뒤로 넣음
                        list.offer(front);
                        for (int k = 0; k < j; k++) {
                            list.offer(list.poll());
                        }
                        check = false;
                        break;
                    }
                }
                // 아직 체크가 false면 반복 돌려
                if (!check) {
                    continue;
                }
                cnt++;
                // 현재 제일 큰놈이 뽑으려는 놈인가?
                if (front[0] == findNum) {
                    break;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
