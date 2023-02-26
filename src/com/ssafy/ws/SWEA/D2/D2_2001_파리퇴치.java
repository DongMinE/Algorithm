package com.ssafy.ws.SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D2_2001_파리퇴치 {
	static int size, ch, arr[][], kill;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			size = Integer.parseInt(st.nextToken());
			arr = new int[size][size];
			ch = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < size; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < size; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			kill = 0;
			for (int i = 0; i <= size-ch; i++) {
				for (int j = 0; j <= size-ch; j++) {
					int firstkill = 0;
					for (int n = 0; n < ch; n++) {
						for (int m = 0; m < ch; m++) {
							firstkill += arr[i+n][j+m];
						}
					}
					kill = Math.max(firstkill, kill);
				}
			}
			 System.out.printf("#%d %d\n",tc+1,kill);
		}

	}

}
