package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 김동민_BOJ_1759_암호만들기 {
	static int L, C;
	static char[] arr, input;
	static boolean[] visited;
	static String[] str;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken()); // 고를 갯수
		C = Integer.parseInt(st.nextToken()); // 원본 배열
		arr = new char[C];
		input = new char[L];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(arr);
		comb(0, 0);
		System.out.println(sb.toString());
	}

	private static void comb(int idx, int cnt) {
		if (cnt == L) {
			// L개 고르면 그거 맞는지 검사하셈
			if (ischeck()) {
				sb.append(input).append("\n");
			}
			return;
		}
		// L개 조합 돌리셈
		for (int i = idx; i < C; i++) {
			input[cnt] = arr[i];
			comb(i + 1, cnt + 1);

		}
	}

	private static boolean ischeck() {
		int chaCnt = 0;
		int gar = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] == 'a'|| input[i] == 'e'|| input[i] == 'i'|| input[i] == 'o'|| input[i] == 'u') {
				chaCnt++;
			}
			else gar++;
		}
		if (chaCnt >= 1 && gar >= 2) return true;
		
		return false;
	}
}
