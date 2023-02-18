package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 김동민_SWEA_9229_한빛이와SpotMart {
	static int snack;
	static int heavy;
	static int[] arr;
	static int res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < T; i++) {
			res = 0;
			//과제 고를 갯수랑 무게 받고
			st = new StringTokenizer(br.readLine());
			snack = Integer.parseInt(st.nextToken());
			heavy = Integer.parseInt(st.nextToken());
			
			//개수만큼 배열 만들고
			arr = new int[snack];
			//토크나이저로 읽은 다음에
			st = new StringTokenizer(br.readLine());
			//배열에 하나씩 넣는다.
			for (int j = 0; j < snack; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0,0,0);
			//System.out.println(Arrays.toString(arr));
			System.out.printf("#%d %d\n",i+1, res);
		}
	}

	private static void dfs(int idx, int cnt, int cursum) {
//		if (cursum > heavy) {
//			return;
//		}
		if (cnt == 2) {
			if (cursum > heavy) return;
			res = Math.max(cursum, res);
			return;
		}
		if (idx == snack) {
			if (res == 0) res = -1;
			return;
		}
		dfs(idx+1, cnt+1, cursum+arr[idx]);
		dfs(idx+1, cnt, cursum);
	}
}
