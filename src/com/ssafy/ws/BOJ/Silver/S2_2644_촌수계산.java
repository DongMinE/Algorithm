package com.ssafy.ws.BOJ.Silver;

import java.io.*;
import java.util.*;

public class S2_2644_촌수계산 {

    private static StringTokenizer st;
    private static ArrayList<Integer>[] list;
    private static int res = -1;
    private static boolean[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //전체 친척 인원
        int n = Integer.parseInt(br.readLine());
        check = new boolean[n + 1];
        //자식 관계 표
        list = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        // 목표 촌수
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        //부모자식 표
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        dfs(a, b, 0);
        System.out.println(res);
    }

    private static void dfs(int a, int b, int o) {
        if (a == b) {
            res = o;
            return;
        }
        check[a] = true;
        for (int i = 0; i < list[a].size(); i++) {
            int next = list[a].get(i);
            if (!check[next]) {
                dfs(next, b, o + 1);
            }
        }

    }
}
