package com.ssafy.live.day17;

import java.util.Arrays;
import java.util.Scanner;

import javax.naming.ldap.SortControl;

public class MST2_Test_kruskal {
	
	static int V, E;
    static Edge[] edgeList;
    static int[] p;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();

        edgeList = new Edge[E];

        for (int i = 0; i < E; i++) {
            edgeList[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(edgeList);
        makeSet();

        int res = 0, cnt = 0;
        for (Edge e : edgeList) {
            if (union(e.from, e.to)) {
                res += e.weight;
                if(++cnt == V-1) break;
            }
        }

        System.out.println(res + "  " + cnt);

    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false;

        p[b] = a;
        return true;
    }

    static void makeSet() {
        p = new int[V];
        for (int i = 0; i < V; i++) p[i] = i;
    }

    static int find(int n) {
        if (p[n] == n) return n;
        return p[n] = find(p[n]);
    }

    static class Edge implements Comparable<Edge>{
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            super();
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}