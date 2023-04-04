package com.ssafy.ws.BOJ.Gold;

import java.util.Scanner;

public class G5_17070_파이프옮기기_DFS_Memo {
	static int[][] map;
	static int N, ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) map[i][j] = sc.nextInt();
		
		solve(0, 1, 0);
		System.out.println(ans + "," + totCnt);
	}
	static int totCnt;
	static void solve(int r, int c, int dir) {   // dir : 0(오), 1(아), 2(대)
		++totCnt;
		if (r + 1 == N && c + 1 ==  N) {
			++ans;
			return;
		}
		if (dir != 1 && c + 1 < N && map[r][c + 1] != 1) solve(r, c + 1, 0);
		if (dir != 0 && r + 1 < N && map[r + 1][c] != 1) solve(r + 1, c, 1);
		if (r + 1 < N && c + 1 < N && map[r + 1][c + 1] != 1 && map[r][c + 1] != 1 && map[r + 1][c] != 1) solve(r + 1, c + 1, 2);
	}
}



/*

15233,71794

12
0 0 0 0 0 0 0 0 0 0 0 0
0 1 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
0 1 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
*/