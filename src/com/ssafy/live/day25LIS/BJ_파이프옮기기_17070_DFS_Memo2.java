package com.ssafy.live.day25LIS;

import java.util.HashMap;
import java.util.Scanner;

public class BJ_파이프옮기기_17070_DFS_Memo2 {
	static int[][] map;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) map[i][j] = sc.nextInt();
		
		System.out.println(solve(0, 1, 0) + "," + callCnt);
	}
	
	static HashMap<String, Long> memo = new HashMap<>();
	static int callCnt = 0;
	static long solve(int r, int c, int dir) {   // dir : 0(오), 1(아), 2(대)
		callCnt++;
		long cnt = 0;
		if(memo.containsKey(r + " " + c + " " + dir)) {
			return memo.get(r + " " + c + " " + dir);
		}
		
		if (r + 1 == N && c + 1 ==  N) {
			return 1;
		}
		
		if (dir != 1 && c + 1 < N && map[r][c + 1] != 1) cnt += solve(r, c + 1, 0);
		if (dir != 0 && r + 1 < N && map[r + 1][c] != 1) cnt += solve(r + 1, c, 1);
		if (r + 1 < N && c + 1 < N && map[r + 1][c + 1] != 1 && map[r][c + 1] != 1 && map[r + 1][c] != 1) cnt += solve(r + 1, c + 1, 2);
		
		memo.put(r + " " + c + " " + dir, cnt);
		return cnt;
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