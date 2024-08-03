package com.ssafy.ws.BOJ.Silver;

import java.io.*;
import java.util.*;


public class S1_1389_케빈베이컨의6단계법칙 {

    //친구 확인 배열
    static ArrayList<Integer>[] list;
    // 거리 확인 배열
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        dist = new int[n + 1];

        //배열 생성
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        //무방향 그래프
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        System.out.println(sol(n));
    }

    private static int sol(int friends) {
        int minCnt = Integer.MAX_VALUE;
        int minIdx = 0;
        for (int i = 1; i <= friends; i++) {
            int cnt = bfs(i);
            if (minCnt > cnt) {
                minCnt = cnt;
                minIdx = i;
            }
        }
        return minIdx;
    }

    private static int bfs(int idx) {
        // 거리 배열 초기화
        Arrays.fill(dist, -1);

        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        dist[idx] = 0;

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int y : list[x]) {
                if (dist[y] != -1) {
                    continue;
                }
                dist[y] = dist[x] + 1;
                cnt += dist[x];
                q.add(y);

            }
        }
        return cnt;
    }
}
