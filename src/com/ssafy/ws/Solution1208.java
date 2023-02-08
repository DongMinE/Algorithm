package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Solution1208 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			
			int cnt = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[101];
			
			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			int min = 0;
			
			for (int j = 0; j < 100; j++) {
				max = Arrays.stream(arr).max().getAsInt();
				min = Arrays.stream(arr).min().getAsInt();
				int idx1 = Arrays.asList(arr).indexOf(max);
				int idx2 = Arrays.asList(arr).indexOf(min);
				System.out.println(idx1);
				System.out.println(idx2);
				arr[idx2]+=1;
				arr[idx1]-=1;
			}
			System.out.println(max-min);
		}
	}

	

}
