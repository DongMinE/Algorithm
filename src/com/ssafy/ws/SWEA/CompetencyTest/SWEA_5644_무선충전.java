package com.ssafy.ws.SWEA.CompetencyTest;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA_5644_무선충전 {
	static int M, A, ans;

	static class User {
		int r, c;

		User(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	//사용자 좌표 저장
	static User u1, u2;	
	//사용자 경로
	static int[] path1, path2; 
	static int[] dr = { 0, -1, 0, 1, 0 };
	static int[] dc = { 0, 0, 1, 0, -1 };

	static class BC {
		int r, c, coverage, performance;

		BC(int c, int r, int coverage, int performance) {
			this.r = r;
			this.c = c;
			this.coverage = coverage;
			this.performance = performance;
		}
	}

	static BC[] bc;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/swea_5644.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(), t = 0;
		while (t++ < T) {
			M = sc.nextInt(); // 총이동시간
			A = sc.nextInt(); // BC 갯수
			path1 = new int[M + 1];
			path2 = new int[M + 1];
			for (int i = 1; i <= M; i++)
				path1[i] = sc.nextInt();
			for (int i = 1; i <= M; i++)
				path2[i] = sc.nextInt();
			bc = new BC[A];
			for (int i = 0; i < A; i++)
				bc[i] = new BC(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
			u1 = new User(1, 1);
			u2 = new User(10, 10);

			solve();
			System.out.println("#" + t + " " + ans);
			ans = 0;
		}

	}

	private static void solve() {
		for (int time = 0; time < M+1; time++) { // 각 시간별 모든 충전소에 접근해서 가장 큰값을 얻는다.
			// 사용자의 위치 이동(aUser, bUser)
			u1.r += dr[path1[time]];
			u1.c += dc[path1[time]];
			u2.r += dr[path2[time]];
			u2.c += dc[path2[time]];
			plusCharge();
		}
	}

	private static void plusCharge() {
		int max = 0;
		for (int a = 0; a < A; a++) { // aUser 선택 BC
			for (int b = 0; b < A; b++) { // bUser 선택 BC
				 int sum = 0;
				int aSum = getBCPerformance(a, u1); //i번째 충전기에 1번사람 됨? 되면 충전아니면 0
				int bSum = getBCPerformance(b, u2); //i번쨰 충전기에 2번사람 됨?
				
				 if (a != b) sum = aSum + bSum; 
				 else sum = Math.max(aSum, bSum); 
				 if (max < sum) max = sum;
				 
				//max = Math.max(max, (a != b) ? aSum + bSum : Math.max(aSum, bSum));
			}
		}
		ans += max;
	}

	private static int getBCPerformance(int idx, User user) {
		return Math.abs(bc[idx].r - user.r) + Math.abs(bc[idx].c - user.c) <= bc[idx].coverage ? bc[idx].performance
				: 0;
	}
}