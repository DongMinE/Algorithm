package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class S1_11286_절대값힙 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1, o2) -> {
			if (Math.abs(o1) == Math.abs(o2)) {
				return o1 - o2;		
			} else {
				return Math.abs(o1) - Math.abs(o2);
			}
		});
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				if (pq.isEmpty())
					sb.append("0").append("\n");
				else
					sb.append(pq.poll()).append("\n");
			} else {
				pq.offer(x);
			}
		}
		System.out.println(sb);
	}

}