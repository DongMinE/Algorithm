package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_14888_연산자끼워넣기 {
	static int n, num[], oper[];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//수의 개수
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		//st의 갯수가 적으면 for문 안쓰고 바로 배열에 넣을 수 있나...? st[0] st[1]같은 방법으로
		//수의 개수만큼 배열 받아 수를 넣음
		num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		//연산자의 개수를 더하기, 빼기, 곱하기, 나누기 개수만큼 넣어줌
		oper = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		dfs(num[0], 1);
		System.out.println(max);
		System.out.println(min);
	}
	private static void dfs(int number, int idx) {
		if (idx == n) {
			max = Math.max(max, number);
			min = Math.min(min, number);
		}
		
//		6
//		1 2 3 4 5 6
//		2 1 1 1
		for (int i = 0; i < 4; i++) {
			// 연산자 개수가 1개 이상인 경우
			if (oper[i] > 0) {
 
				// 해당 연산자를 1 감소시킨다.
				oper[i]--;
 
				switch (i) {
//				???? 이게 왜 모든 경우의 연산사 삽입이 되는거지
				case 0:	dfs(number + num[idx], idx + 1);	break;
				case 1:	dfs(number - num[idx], idx + 1);	break;
				case 2:	dfs(number * num[idx], idx + 1);	break;
				case 3:	dfs(number / num[idx], idx + 1);	break;
 
				}
				// 재귀호출이 종료되면 다시 해당 연산자 개수를 왜 복구함???
				oper[i]++;
			}
		}
	}
}
