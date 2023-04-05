package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 김동민_BOJ_15961_회전초밥 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 벨트에 초밥 개수
		int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); // 연속먹을 개수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰번호

		// 최대 초밥 가짓수
		int[] susi = new int[d+1];
		// 초밥 먹은 종류
		int cnt = 0;
		// 최대 개수 저장
		int res = 0;
		// 배열넣기
		int[] arr = new int[N + k - 1];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		// 4개를 뽑을 때 맨 뒤부터 먹을 경우 (맨끝 -> 처음 -> 처음+1 -> 처음+2)
		// N+k-1 개만큼 갖는다
		for (int i = N, j = 0; i < N + k - 1; i++, j++) {
			arr[i] = arr[j];
		}
		//쿠폰 처음부터 먹은 걸로 치자
		cnt++;
		susi[c]++;
		// 처음 먹음
		int start = 0;
		for (int i = start; i < k; i++) {
			if (susi[arr[i]] == 0) cnt++;
			susi[arr[i]]++;
			
		}
		res = cnt;
		//다음에 먹을 초밥 경우 체크
		for (int i = k; i < arr.length; i++) {
			//처음에 먹은 초밥 번호 빼기
			susi[arr[start]]--;
			//처음 초밥 번호 뺐더니 0이 되면 초밥 개수에서도 빼기
			if (susi[arr[start]] == 0) cnt--;
			//새롭게 마지막에 먹은 초밥만 처음 먹으면 개수 증가 
			if (susi[arr[i]] == 0) cnt++;
			//해당 스시번호 증가
			susi[arr[i]]++;
			
			//뭐가 많이 먹는 경우인지 체크
			res = Math.max(cnt, res);
			//다음 경우 보러 가기 전에 처음먹은 초밥 번호 층가
			start++;
			
		}
		
		System.out.println(res);
	}
}
