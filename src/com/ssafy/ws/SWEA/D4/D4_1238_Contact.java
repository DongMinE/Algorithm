package com.ssafy.ws.SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1238_Contact {
	static class Vertax implements Comparable<Vertax> {
		int no, cost;
		Vertax(int no, int cost) {
			this.no = no;
			this.cost = cost;
		}
		@Override
		public int compareTo(Vertax o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] people = new int[100][100];
		for (int tc = 1; tc < 11; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			
			int[][] data = new int[101][101];
			int f,t;
			for (int i = 0; i < 101; i++) {
				f = Integer.parseInt(st.nextToken());
				t = Integer.parseInt(st.nextToken());
				data[f][t] = 1;
			}
			dfs(0, new boolean[101]);
		}
	}

	private static void dfs(int i, boolean[] bs) {
		
		
		
	}
}
