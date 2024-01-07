package com.ssafy.ws.SWEA.Battle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 동계대학생_24년도_SW알고리즘특강_사전문제_1번 {

    private static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuffer sb = new StringBuffer();
//        StringTokenizer st;
//        int N = Integer.parseInt(br.readLine());
//
//        LinkedList<Integer> list;
//        for (int j = 0; j < N; j++) {
//            st = new StringTokenizer(br.readLine());
//
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//
//            int s, e; // n이 작은놈, k가 큰놈
//            if (a > b) {
//                e = a;
//                s = b;
//            } else {
//                s = a;
//                e = b;
//            }
//
//            list = new LinkedList<>(); // 삼각김밥 배열 끝수 모음
//            int m = 1; // N번째 삼각김밥 배열의 오른쪽 가장 끝의 수
//            list.offer(0);
//            list.offer(1);
//            int floor = 2; // 첫번째 가장 끝수 1다음 2층부터 노드가 2개씩이니까 2부터 시작
//
//            // 오른쪽 가장 끝 수만 list에 추가 됨
//            while (m <= 10000) {
//                m += floor;
//                list.offer(m);
//                floor++;
//            }
//            int num = 1; // 큐에 넣을 누적된 숫자
//            int cnt = 1; // 증가 숫자
//            LinkedList<int[]> queue = new LinkedList<>(); // 삼각김밥 배열 i번째에 연결가능한 노드 번호 리스트
//            queue.offer(new int[] {});
//            for (int i = 1; i < 10; i++) {
//                for (int k = i; k <= list.get(i); k++) {
//                    if (k == list.get(i)) {
//                        queue.offer(new int[] {k + cnt, k + cnt + 1});
//                    } else {
//                        queue.offer(new int[]{k + 1, k + cnt, k + cnt + 1});
//                    }
//                }
//                cnt++;
//            }
//
//
//            System.out.println(list);
//            for (int[] arr : queue) {
//                System.out.println(Arrays.toString(arr));
//            }
//        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        // 1. 그래프 만들기
        // 1-1. 오른쪽을 넣냐 안넣냐 조건 탐색, 현재 층수 알아내기, 자식 추가하기
        graph = new List[10001];
        for (int i = 1; i <= 10000; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= 10000; i++) {
            int n = 층수
            graph[i].add(i + n);
            graph[i].add(i + n + 1);
            if (i != 끝) {
                graph[i].add(i + 1);
            }
        }

        // 3, 4 ,5
        // n + 1, n + n, n + n + 1
        StringBuffer sb = new StringBuffer();
        for (int tc = 1; tc <= T; tc++) {
            // 2. bfs 구현
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int result = bfs(Math.min(a, b), Math.max(a, b));

            sb.append(result).append('\n');
            // 3. 출력
        }
    }

    private static int bfs(int start, int target) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{start, 0});

        boolean[] visited = new boolean[10001];

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (visited[cur[0]]) continue;
            visited[cur[0]] = true;

            if (cur[0] == target) {
                return cur[1];
            }

            // cur[0]
            for (int i = 0; i < graph[cur[0]].size(); i++) {
                int next = graph[cur[0]].get(i);

                if (!visited[next]) {
                    q.offer(new int[]{next, cur[1] + 1});
                }
            }
        }
        return -1;
    }
}
