package com.ssafy.ws.SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_3289_서로소집합 {
	static int size, chance, arr[], input[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 0; tc < T; tc++) {
			System.out.printf("#%d ", tc+1);
			st = new StringTokenizer(br.readLine());
			size = Integer.parseInt(st.nextToken());
			chance = Integer.parseInt(st.nextToken());
			arr = new int[size];
			makeSet();
			input = new int[chance];
			for (int k = 0; k < chance; k++) {
				st = new StringTokenizer(br.readLine());
				int mode = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				//System.out.println(Arrays.toString(arr));
				if (mode == 0) union(a-1,b-1);
				if (mode == 1) check(a-1,b-1);
			}
			System.out.println();
			
			
			
		}
	}

	private static void check(int i, int j) {
		if (arr[i] == arr[j]) System.out.print(1);
		if (arr[i] != arr[j]) System.out.print(0);
	}

	private static int union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot==bRoot) return 0;
		
		arr[bRoot] = aRoot;
		return 1;
	}
	
	private static int find(int a) {
		if (arr[a] == a) return a;
		
		return arr[a] = find(arr[a]);
	}
	
	private static void makeSet() {
		for (int i = 0; i < size; i++) {
			arr[i] = i;
		}
		
	}
}
