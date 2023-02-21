package com.ssafy.ws.BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_2493_탑 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] data = new int[N + 1];
		int[] D = new int[N + 1];
		for (int i = 1; i <= N; i++)
			data[i] = Integer.parseInt(st.nextToken());

		D[1] = 0;
		for (int i = 2; i <= N; i++) {
			
			int j = i-1;
			while (j > 0) {
				if (data[i] < data[j]) {
					D[i] = j;
					break;
				}
				j = D[j];
			}
		}
		for (int i = 1; i <= N; i++) {
			System.out.print(D[i] + " ");
		}

	}
}
