package com.ssafy.ws.SWEA.CompetencyTest;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SWEA4012_요리사 {

	static int[][] food;
	static boolean[] selects;
	static int n;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			//input
			n = Integer.parseInt(br.readLine());
			food = new int[n][n];
			selects = new boolean[n];
			answer = 20000;
			
			for(int i=0; i<n; i++) {
				StringTokenizer tk = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					food[i][j] = Integer.parseInt(tk.nextToken());
				}
			}
			combination(0,0);

			sb.append("#" + t+ " " + answer +'\n');
		}
		System.out.println(sb.toString());
	}   
	
	
	static int cal() {
		int x=0;
		int y=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i==j) continue;
				if(selects[i] && selects[j]) {
					x+=food[i][j];
				}
				else if(!selects[i] && !selects[j]){
					y+=food[i][j];
				}
			}
		}
		return Math.abs(x-y);
	}
	
	static void combination(int idx, int cnt) {
		if(cnt==n/2) {
			answer = Math.min(answer,cal());
			return;
		}
		
		for(int i=idx; i< n; i++) {
			selects[i]=true;
			combination(i+1,cnt+1);
			selects[i]=false;
		}
	}
}

