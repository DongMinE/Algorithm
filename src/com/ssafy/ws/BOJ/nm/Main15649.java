package com.ssafy.ws.BOJ.nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main15649 {
	static int n, m;
	static boolean[] visited;
	static int[] numbers, input;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n];
		numbers = new int[m];
		input = new int[n];
		for (int i = 1; i <= n; i++)
			input[i-1] = i;
		perm(0);

	}

	private static void perm(int cnt) {
		if (cnt == m) {
			for (int v : numbers) {
				System.out.print(v + " ");
			}
			System.out.println();
			return;
		}
		for (int j = 0; j < n; j++) {
			if (visited[j])
				continue;
			visited[j] = true;
			numbers[cnt] = input[j];
			perm(cnt + 1);
			visited[j] = false;
		}

	}

}
