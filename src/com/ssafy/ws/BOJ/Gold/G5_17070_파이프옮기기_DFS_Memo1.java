package com.ssafy.ws.BOJ.Gold;

import java.util.Scanner;

public class G5_17070_파이프옮기기_DFS_Memo1 {
	static int[][] map;
	static int N;
	static long[][][] D;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		D = new long[N][N][3];
		for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) {
			map[i][j] = sc.nextInt();
            for (int d = 0; d < 3; d++) {
                D[i][j][d] = -1;
            }
		}
		System.out.println(solve(0, 1, 0) + "," + callCnt);
	}
	
	static int callCnt = 0;
	static long solve(int r, int c, int dir) {   // dir : 0(오), 1(아), 2(대)
		callCnt++;
		
		if (D[r][c][dir] != -1) return D[r][c][dir];
		
		if (r + 1 == N && c + 1 ==  N) {
			return 1;
		}
		
		long cnt = 0;
		if (dir != 1 && c + 1 < N && map[r][c + 1] != 1) cnt += solve(r, c + 1, 0);
		if (dir != 0 && r + 1 < N && map[r + 1][c] != 1) cnt += solve(r + 1, c, 1);
		if (r + 1 < N && c + 1 < N && map[r + 1][c + 1] != 1 && map[r][c + 1] != 1 && map[r + 1][c] != 1) cnt += solve(r + 1, c + 1, 2);
		return D[r][c][dir] = cnt;
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