
package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_1920_수찾기 {
	static int N, M, e, s, res;
	static int[] arr1, arr2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr1 = new int[N];
		for (int i = 0; i < N; i++)
			arr1[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr1);

		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int x = Integer.parseInt(st.nextToken());
			if (solve(x) >= 0) 
				System.out.println(1);
			else System.out.println(0);
			
		}
		
		
		
	}

	private static int solve(int data) {
			s = 0;
			e = arr1.length-1;
			while (s <= e) {
				int mid = (e+s)/2;
				if (data > arr1[mid]) {
					s = mid +1;
				}
				else if (data < arr1[mid]) {
					e = mid -1;
				}
				else {
					return mid;
				}
			}
			return -1;
			
	}
}
