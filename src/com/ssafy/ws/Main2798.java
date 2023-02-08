package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2798 {
	static int totalcard, limit;
	static int max = 0;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		totalcard = Integer.parseInt(st.nextToken());
		limit = Integer.parseInt(st.nextToken());
		arr = new int[totalcard];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < totalcard; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		sol(0,0,0);
		System.out.println(max);
	}
	private static void sol(int idx, int score, int use) {
		
		if (score > limit) {
			return;
		}
		if (use ==3) {
			if (score <= limit) {
				max = Math.max(max, score);
			}
			return;
		}
		if (idx == totalcard) {
			return;
		}
		
		
		sol(idx+1, score + arr[idx], use+1);
		sol(idx+1, score, use);
	}
}
