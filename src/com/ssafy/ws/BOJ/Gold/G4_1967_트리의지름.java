package com.ssafy.ws.BOJ.Gold;

import java.io.*;
import java.util.*;

public class G4_1967_트리의지름 {

    private static class Node {

        int to;
        int cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static List<Node>[] list;
    static boolean[] visit;
    static int dis, can;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[cur].add(new Node(next, cost));
            list[next].add(new Node(cur, cost));
        }
//        for (int i = 0; i < list.length; i++) {
//            System.out.println(i + "노드");
//            for (int j = 0; j < list[i].size(); j++) {
//                System.out.print(
//                    "to: " + list[i].get(j).to + " , cost: " + list[i].get(j).cost + " ");
//            }
//            System.out.println();
//        }

        //양 끝단 중 한개 찾기
        dfs(1, 0);
        //방문 배열 초기화
        visit = new boolean[n + 1];
        //찾은 하나로 최대 길이 찾기
        dfs(can, 0);
        System.out.println(dis);
    }

    private static void dfs(int start, int sum) {
        if (dis < sum) {
            dis = sum;
            can = start;
//            System.out.println(can + " " + dis);
        }
        visit[start] = true;
        for (int i = 0; i < list[start].size(); i++) {
            Node next = list[start].get(i);
            if (!visit[next.to]) {
                dfs(next.to, sum + next.cost);
            }
        }
    }

}
