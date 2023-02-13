package com.ssafy.ws.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class D3_1228_암호문1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int one = Integer.parseInt(br.readLine());
			LinkedList<String> origin = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < one; i++) {
				origin.add(st.nextToken());
			}
			int two = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < two; j++) {
				String tresh = st.nextToken();
				int getIdx = Integer.parseInt(st.nextToken());
				int location = Integer.parseInt(st.nextToken());
				for (int k = 0; k <location; k++) {
					origin.add(getIdx++,st.nextToken());
				}
			}
			//System.out.println(origin);
			System.out.printf("#%d ", t);
			for(int i=0; i<10; i++) System.out.print(origin.get(i) + " ");
			System.out.println();
		}
		
		
	}

}
