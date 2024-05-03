package com.ssafy.ws.BOJ.Gold;

import java.io.*;
import java.util.*;

public class G4_1753_최단경로 {

    private static class Node {

        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static ArrayList<Node>[] graph;
    static boolean[] visit;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());

        graph = new ArrayList[v + 1];
        visit = new boolean[v + 1];
        dist = new int[v + 1];

        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int inputU = Integer.parseInt(st.nextToken());
            int inputV = Integer.parseInt(st.nextToken());
            int inputW = Integer.parseInt(st.nextToken());

            graph[inputU].add(new Node(inputV, inputW));
        }

        dijk(k);

        for (int i = 1; i < v + 1; i++) {
            System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
        }
    }

    private static void dijk(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        q.add(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (!visit[now.v]) {
                visit[now.v] = true;

                for (Node next : graph[now.v]) {
                    if (dist[next.v] > now.cost + next.cost) {
                        dist[next.v] = now.cost + next.cost;
                        q.add(new Node(next.v, dist[next.v]));
                    }
                }
            }


        }
    }
}
