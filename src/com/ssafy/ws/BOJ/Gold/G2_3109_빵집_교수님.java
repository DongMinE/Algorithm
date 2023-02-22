package com.ssafy.ws.BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G2_3109_빵집_교수님 {
	static int ans, R, C;
	static char arr[][];
	static int[] dr = { -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][];
		for (int i = 0; i < R; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < R; i++)
			back(i, 0);
		System.out.println(ans);

//		for (char[] v : arr)
//			System.out.println(Arrays.toString(v));
	}

	private static boolean back(int r, int c) {
		arr[r][c] = 'x';
		if (c == C -1) {
			ans++;
			return true;
		}
		
		int nr, nc = c + 1;
		for (int d = 0; d < 3; d++) {
			nr = r +dr[d];
			if(nr < 0 || nr >= R || arr[nr][nc] == 'x') continue;
			if (back(nr,nc)) return true;
			
		}
		return false;
	}
}
