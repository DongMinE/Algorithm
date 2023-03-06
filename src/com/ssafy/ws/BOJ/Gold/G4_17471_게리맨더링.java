package com.ssafy.ws.BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_17471_게리맨더링 {
	static int size, arr[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		arr = new int[size+1][size+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		//인구수 담기
		for (int i = 1; i < arr.length; i++) arr[i][0] = Integer.parseInt(st.nextToken());
		//구역 담기
		for (int i = 1; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			int linkNumber = Integer.parseInt(st.nextToken());
			for (int j = 0; j < linkNumber; j++) {
				int temp = Integer.parseInt(st.nextToken());
				arr[i][temp] = 1;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
}
