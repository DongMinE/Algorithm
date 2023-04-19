package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class S2_15787_기차가어둠을헤치고은하수를 {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 기차 배열 (인덱스 1 부터 시작, N까지)
		arr = new int[N+1];
		
		// 명령어 수행
		for(int i=0;i<M;i++) {
			sol(br.readLine());
		}
		
		// 중복 제거
		HashSet<Integer> set = new HashSet<>();
		for(int i=1;i<N+1;i++) {
			set.add(arr[i]);
		}
		
		// 출력
		System.out.println(set.size());
		
	}
	
	public static void sol(String num) {
		StringTokenizer st = new StringTokenizer(num);
		
		int c = Integer.parseInt(st.nextToken()); // 명령
		int i = Integer.parseInt(st.nextToken()); // 기차 번호
		// case 3,4는 x가 없음
		//x가 1부터 시작해서 0부터로 바꿔주기 위해 초기값 -1로 설정 이후 x에 입력값을 더해
		int x = -1; 
		
		switch (c){
		// 좌석에 사람 태워
		case 1:
			x += Integer.parseInt(st.nextToken());
			arr[i] |= (1 << x);
			break;
		// 좌석의 사람 하차
		case 2:
			x += Integer.parseInt(st.nextToken());
			//arr[i] &= ^(1 << x);
			arr[i] &= ~(1 << x);
			break;
		// 한 칸씩 뒤로 밀고 맨 뒤 사람 하차
		// (arr[i] & ~(1 << 19))이게 왜 왜 뒤로 미는거임??
		case 3:
			arr[i] = (arr[i] & ~(1 << 19)) << 1;
			break;
		// 맨 앞 사람 하차시키고 한 칸씩 앞으로 당기기
		case 4:
			arr[i] = (arr[i] & ~(1 << 0)) >> 1;
			break;
		}
	}

}