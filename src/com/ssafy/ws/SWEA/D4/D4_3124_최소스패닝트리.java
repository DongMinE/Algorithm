package com.ssafy.ws.SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
1
3 3
1 2 1
2 3 2
1 3 3

*/
public class D4_3124_최소스패닝트리 {
	static int V, E;
	static ArrayList<Edge> edgeList;
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			edgeList = new ArrayList<Edge>();
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				edgeList.add(new Edge(Integer.parseInt(st.nextToken())-1, 
						Integer.parseInt(st.nextToken())-1, 
						Integer.parseInt(st.nextToken())));
			}
			Collections.sort(edgeList);
			makeSet();
			
			long res = 0, cnt = 0;
			for (Edge e : edgeList) {
				if (union(e.from, e.to)) {
					res += e.weight;
					if (++cnt == V-1) break;
				}
			}
			System.out.printf("#%d %d\n",tc+1, res);
		}
	}
	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) return false;
		
		p[b] = a;
		return true;
	}
	private static void makeSet() {
		p = new int[V];
		for (int i = 0; i < V; i++) p[i] = i;
		
	}
	
	static int find(int n) {
		if (p[n] == n) return n;
		return p[n] = find(p[n]);
	}
	
	static class Edge implements Comparable<Edge> {
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
