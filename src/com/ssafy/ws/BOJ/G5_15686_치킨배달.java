package com.ssafy.ws.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class G5_15686_치킨배달 {

	static int[][] arr;
	static int N, M;
	static ArrayList<Point> person;
	static ArrayList<Point> chicken;
	static int ans;
	static boolean[] open;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		person = new ArrayList<>();
		chicken = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (arr[i][j] == 1)
					person.add(new Point(i, j));
				else if (arr[i][j] == 2)
					chicken.add(new Point(i, j));
			}
		}
		ans = Integer.MAX_VALUE;
		open = new boolean[chicken.size()];

		dfs(0, 0);
		System.out.println(ans);
	}

	private static void dfs(int idx, int cnt) {
		if (cnt == M) {
			int res = 0;
			for (int i = 0; i < person.size(); i++) {
				int temp = Integer.MAX_VALUE;
				for (int j = 0; j < chicken.size(); j++) {
					if (open[j]) {
						int distance = Math.abs(person.get(i).x - chicken.get(j).x)
								+ Math.abs(person.get(i).y - chicken.get(j).y);
						temp = Math.min(temp, distance);
					}
				}
				res += temp;
			}
			ans = Math.min(res, ans);
			return;
		}
		for (int i = idx; i < chicken.size(); i++) {
			open[i] = true;
			dfs(i + 1, cnt + 1);
			open[i] = false;
		}
	}

}
