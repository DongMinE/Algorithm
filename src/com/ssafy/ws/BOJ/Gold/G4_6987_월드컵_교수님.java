package com.ssafy.ws.BOJ.Gold;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
5 0 0 3 0 2 2 0 3 0 0 5 4 0 1 1 0 4
4 1 0 3 0 2 4 1 0 1 1 3 0 0 5 1 1 3
5 0 0 4 0 1 2 2 1 2 0 3 1 0 4 0 0 5
5 0 0 3 1 1 2 1 2 2 0 3 0 0 5 1 0 4

 */
public class G4_6987_월드컵_교수님 {
	static int[][] matchs = new int[15][2];
	static int[][] result = new int[6][3]; // 완탐 결과
	static int[][] data = new int[6][3]; // 입력 데이터
	static int ans;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int idx = 0;
		for (int i = 0; i < 5; i++)
			for (int j = i + 1; j < 6; j++)
				matchs[idx++] = new int[] { i, j }; // 홈팀, 어웨이팀

		for (int i = 0; i < 4; i++) {
			int score = 0;
			for (int j = 0; j < 6; j++) {
				data[j] = new int[] { sc.nextInt(), sc.nextInt(), sc.nextInt() }; // 승 무 패
				score += data[j][0] + data[j][1] + data[j][2]; // 합이 30이여야 함
			}
			if (score == 30) {
				dfs(0);
			}
			System.out.println(ans);
			ans = 0;
		}
	}

	private static void dfs(int cnt) {
		if (cnt == 15) {
			if (Arrays.deepToString(result).equals(Arrays.deepToString(data))) {
				ans = 1;
			}
			return;
		}
		// 승 무 패
		int t1 = matchs[cnt][0], t2 = matchs[cnt][1];
		// t1 win, t2 lose
		if (result[t1][0] + 1 <= data[t1][0] && result[t2][2] <= data[t2][2]) {
			result[t1][0]++;
			result[t2][2]++;
			dfs(cnt + 1);
			result[t1][0]--;
			result[t2][2]--;
		}
		// t1, t2 draw
		if (result[t1][1] + 1 <= data[t1][1] && result[t2][1] <= data[t2][1]) {
			result[t1][1]++;
			result[t2][1]++;
			dfs(cnt + 1);
			result[t1][1]--;
			result[t2][1]--;
		}
		// t1 lose, t2 win
		if (result[t1][2] + 1 <= data[t1][2] && result[t2][0] <= data[t2][0]) {
			result[t1][2]++;
			result[t2][0]++;
			dfs(cnt + 1);
			result[t1][2]--;
			result[t2][0]--;
		}
	}

}
