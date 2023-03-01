package com.ssafy.ws.SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D4_1238_Contact {
	static int[][] people;
	static int start, res;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int tc = 1; tc < 11; tc++) {
			st = new StringTokenizer(br.readLine());
			people = new int[101][101];
			visit = new boolean[101];

			int Case = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < Case / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				people[from][to] = 1;
			}

			System.out.print("#" + tc + " ");
			bfs(start);
		}
	}

	private static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		visit[x] = true;
		int max = 0;
		ArrayList<Integer> list = new ArrayList<>();

		while (!q.isEmpty()) {
			int size = q.size();
			max = -1;
			for (int i = 0; i < size; i++) {
				int current = q.poll();
				for (int j = 1; j < 101; j++) {
					if (people[current][j] == 1 && !visit[j]) {
						q.offer(j);
						visit[j] = true;
						//해당 레벨의 최대값을 max로 저장
						max = Math.max(max, j);
					}
				}
			}
			//max값을 리스트에 저장
			list.add(max);
		}
//		for(int i = 0; i < list.size(); i++) {
//			System.out.print(list.get(i) + " ");
//		}
//		System.out.println();
		
		//리스트의 마지막값(최대레벨의 최대값을 출력
		System.out.println(list.get(list.size() - 2));
	}

}
