package swTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SW1952_수영장 {
	static int ans;
	static int[] cost = new int[4];
	static int[] month = new int[12];
	static int[] ms = {1,1,3};

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/SWEA1952.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(), t = 0;
		while (t++ < T) {
			ans = 1 << 30;
			for (int i = 0; i < 4; i++) cost[i] = sc.nextInt();
			for (int i = 0; i < 12; i++) month[i] = sc.nextInt();
			
			solve(0,0);
			System.out.println("#" + t + " " + Math.min(ans,  cost[3]));
		}
	}

	private static void solve(int cnt, int sum) {
		if (sum > ans) return;
		if (cnt >= 12) {
			ans = Math.min(ans,  sum);
			return;
		}
		for (int i = 0; i < 3; i++) {
			solve(cnt+ms[i],sum+((i==0) ? cost[i] * month[cnt] : cost[i]));
		}
	}

}
