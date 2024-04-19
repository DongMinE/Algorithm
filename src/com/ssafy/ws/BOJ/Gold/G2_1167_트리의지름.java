package com.ssafy.ws.BOJ.Gold;

import java.io.*;
import java.util.*;

public class G2_1167_트리의지름 {

    private static class Node {

        int to;
        int cost;

        public Node(int to, int cost) {
            this.cost = cost;
            this.to = to;
        }
    }

    static int v;
    static ArrayList<Node>[] list;
    static boolean visit[];
    static int res;
    static int can;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        v = Integer.parseInt(br.readLine());

        list = new ArrayList[v + 1];
        visit = new boolean[v + 1];

        for (int i = 0; i < v + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex = Integer.parseInt(st.nextToken());
            while (true) {
                int next = Integer.parseInt(st.nextToken());
                if (next == -1) {
                    break;
                }
                int cost = Integer.parseInt(st.nextToken());
                list[vertex].add(new Node(next, cost));
            }
        }
        dfs(1, 0);

        visit = new boolean[v + 1];
        dfs(can, 0);
        System.out.println(res);
    }

    private static void dfs(int v, int dis) {
        if (dis > res) {
            res = dis;
            can = v;
        }
        visit[v] = true;
        for (int i = 0; i < list[v].size(); i++) {
            Node next = list[v].get(i);
            if (!visit[next.to]) {
                dfs(next.to, dis + next.cost);
            }
        }
    }
}
