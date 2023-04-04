package com.ssafy.ws.BOJ.Gold;

import java.awt.Point;
import java.util.Arrays;
import java.util.Scanner;

public class G5_9205_맥주마시면서걸어가기_Floyd {
	static int N;
	static int map[][];
	static Point arr[];
	static int INF = 987654321;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(), t = 0;
		while (t++ < T) {
			N = sc.nextInt();
			arr = new Point[N + 2];
			map = new int[N + 2][N + 2];

			for (int i = 0; i < N + 2; i++) Arrays.fill(map[i], INF);

			for (int i = 0; i < N + 2; i++) {
				arr[i] = new Point(sc.nextInt(), sc.nextInt());
			}

			for (int i = 0; i < N + 1; i++) {
				for (int j = i + 1; j < N + 2; j++) {
					if (checkDist(i, j)) {
						map[i][j] = map[j][i] = 1;
					}
				}
			}
			floyd();
			System.out.println(map[0][N + 1] == INF ? "sad" : "happy");
		}
	}

	static boolean checkDist(int i, int j) {
		return Math.abs(arr[i].x - arr[j].x) + Math.abs(arr[i].y - arr[j].y) <= 1000;
	}
	
	static void floyd() {
		for (int k = 0; k < N + 2; k++) {
			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {
					if (map[i][j] > map[i][k] + map[k][j])
						map[i][j] = map[i][k] + map[k][j];
				}
			}
		}
	}

} // end class