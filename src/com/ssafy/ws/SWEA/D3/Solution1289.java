package com.ssafy.ws.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1289 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			char[] check = str.toCharArray();
			int cnt = 0;
			char cha = '0';
			for (int j = 0; j < str.length(); j++ ) {
				if (cha != check[j]) {
					cha =  check[j];
					cnt++;
				}
	
			}
			System.out.printf("#%d %d\n",i+1,cnt);
			
		}
	
	
	
	}

}
