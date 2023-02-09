package com.ssafy.ws.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11659 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int[] check = new int[n+1];
		int checksum = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			checksum += arr[i];
			check[i+1] = checksum;
		}
		//StringBuilder sb = new StringBuilder();
		int res= 0;
		for (int k = 0; k < m; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			System.out.println(check[j] - check[i-1]);
//			int sum = 0;
//			for (int o = i-1; o < j; o++) {
//				sum += arr[o];
//			}
//			sb.append(sum).append("\n");
//		}
//		System.out.println(sb);
		}
		
	}

}
