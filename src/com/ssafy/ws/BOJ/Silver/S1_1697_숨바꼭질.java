package com.ssafy.ws.BOJ.Silver;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class S1_1697_숨바꼭질 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		if (N == M) {
			System.out.println(0);
			return;
		}
		int[] time = new int[100001];
		Arrays.fill(time, -1);
		int second = 0;
		time[N] = second++;

		Queue<Integer> q = new ArrayDeque<>();
		q.offer(N);

		int[] dir = { -1, 1, 2 };
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int now = q.poll();
				for (int d = 0; d < 3; d++) {
					int loc = (d == 2) ? now * dir[d] : now + dir[d];
					if (loc < 0 || loc >= 100001) continue;
					if (time[loc] == -1) {
						q.offer(loc);
						time[loc] = second;
					}
				}
			}
			if (time[M] != -1) break;
			second++;
		}
		System.out.println(time[M]);
	}
}
