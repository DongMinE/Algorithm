package com.ssafy.ws.BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class G4_1504_특정한_최단경로 {

    private static class Node1504 implements Comparable<Node1504> {

        int end;
        int weight;

        Node1504(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node1504 o) {
            return weight - o.weight;
        }
    }

    static int n, e;
    static ArrayList<ArrayList<Node1504>> list;
    static int[] dist;
    static boolean[] check;
    static final int INF = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        dist = new int[n + 1];
        check = new boolean[n + 1];
        Arrays.fill(dist, INF);

        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node1504(end, weight));
            list.get(end).add(new Node1504(start, weight));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int sol1 = 0;
        sol1 += dijk(1, v1);
        sol1 += dijk(v1, v2);
        sol1 += dijk(v2, n);

        int sol2 = 0;
        sol2 += dijk(1, v2);
        sol2 += dijk(v2, v1);
        sol2 += dijk(v1, n);

        int res = sol1 >= INF && sol2 >= INF ? -1 : Math.min(sol1, sol2);
        System.out.println(res);
    }

    private static int dijk(int start, int end) {
        Arrays.fill(dist, INF);
        Arrays.fill(check, false);

        PriorityQueue<Node1504> pq = new PriorityQueue<>();
        pq.add(new Node1504(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node1504 current = pq.poll();
            int cur = current.end;
            if (!check[cur]) {
                check[cur] = true;

                for (Node1504 node : list.get(cur)) {
                    if (!check[node.end] && dist[node.end] > dist[cur] + node.weight) {
                        dist[node.end] = dist[cur] + node.weight;
                        pq.add(new Node1504(node.end, dist[node.end]));
                    }
                }
            }
        }

        return dist[end];
    }
}
