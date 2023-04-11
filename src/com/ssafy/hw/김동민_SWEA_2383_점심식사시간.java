package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 김동민_SWEA_2383_점심식사시간 {
	static int N, cnt, ans;
	static final int M = 1, W = 2, D = 3, C = 4; // 이동중, 대기중 내려가는중, 완료

	static class Person implements Comparable<Person> {
		int r, c, arrivalTime, downCnt, status;

		public Person(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public void init() {
			arrivalTime = downCnt = 0;
			status = M;
		}

		@Override
		public int compareTo(Person o) {
			return Integer.compare(this.arrivalTime, o.arrivalTime);
		}
	}

	static ArrayList<Person> pList;
	static int[][] sList;
	static int[] selected;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			pList = new ArrayList<Person>();
			sList = new int[2][];
			ans = Integer.MAX_VALUE;
					
			StringTokenizer st = null;

			for (int i = 0, k = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int c = Integer.parseInt(st.nextToken());
					if (c == 1) {
						pList.add(new Person(i, j));
					} else if (c > 1) { // 계단
						sList[k++] = new int[] { i, j, c };
					}
				}
			}
			cnt = pList.size();
			selected = new int[cnt];
			divide(0);
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void divide(int index) {
		if (index == cnt ) {
			int res = go();
			if (ans>res) ans = res;
			return;
		}
		//계단 0 선택
		selected[index] = 0;
		divide(index+1);
		//계단 1 선택
		selected[index] = 1;
		divide(index+1);
	}
	
	static int go() {
		ArrayList<Person>[] list = new ArrayList[]{new ArrayList<Person>(), new ArrayList<Person>() };
		
		for (int i = 0; i < cnt; i++) {
			Person p = pList.get(i);
			p.init(); //사람의 상태를 초기화
			int no = selected[i]; 
			p.arrivalTime = Math.abs(p.r-sList[no][0]) + Math.abs(p.c - sList[no][1]);
			list[no].add(p);
		}
		int timeA = 0, timeB = 0;
		if (list[0].size() > 0) {
			timeA = processDown(list[0],sList[0][2]);
		}
		if (list[1].size() > 0) {
			timeB = processDown(list[1],sList[1][2]);
		}
		return timeA > timeB ? timeA : timeB;
	}
	
	static int processDown(ArrayList<Person> list, int height) {
		Collections.sort(list);
		int time = list.get(0).arrivalTime;
		int size = list.size();
		
		int ingCnt = 0, cCnt = 0;
		Person P = null;
		while(true) {
			for (int i = 0; i < size; i++) {
				P = list.get(i);
				
				if (P.status == C) {
					continue;
				}else if (P.arrivalTime == time) {
					P.status = W;
				}else if (P.status == W && ingCnt < 3) {
					P.status = D;
					P.downCnt = 1;
					ingCnt++;
				}else if (P.status == D) {
					if (P.downCnt == height) {
						P.status = C;
						ingCnt--;
						cCnt++;
					}else {
						P.downCnt++;
					}
				}
			} // 해당 시간에 모든 사람에 대해 처리
			if (cCnt == size) break;
			time += 1;
		}
		return time;
	}
		
}
