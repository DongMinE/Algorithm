package com.ssafy.ws.BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.AllPermission;
import java.util.Arrays;

public class G5_10026_적록색약 {
	static int N, cnt;
	static char[][] arr, originarr;
	static int[] dr = { 0, 0, -1, 1 }, dc = { 1, -1, 0, 0 };
	static boolean[][] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		originarr = new char[N][N];
		check = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
			originarr[i] = arr[i];

		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!check[i][j]) {
				solve(i, j);
				cnt++;
				}
			}
		}
		int ans1 = cnt;
		cnt = 0;
		check = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j]=='G')
					arr[i][j]='R';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!check[i][j]) {
				solve(i, j);
				cnt++;
				}
			}
		}
		int  ans2 = cnt;
		System.out.println(ans1 + " " + ans2);
	}
	

//		System.out.println(Arrays.deepToString(arr));
//		System.out.println(Arrays.deepToString(originarr));

	private static void solve(int x, int y) {
		char temp = arr[x][y];
		check[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				continue;
			if (arr[nx][ny] == temp && !check[x][y]) {
				cnt++;
				solve(nx, ny);
			}
		}
	}
}
