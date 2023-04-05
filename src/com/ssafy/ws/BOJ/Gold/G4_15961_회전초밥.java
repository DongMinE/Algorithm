package com.ssafy.ws.BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_15961_회전초밥 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 벨트에 초밥 개수
		int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); // 연속먹을 개수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰번호

		//최대 초밥 가짓수
		int[] susi = new int[3000];
		//초밥 먹은 종류
		int Nzero = 0;
		//배열넣기
		int[] arr = new int[N + k - 1];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		// 4명을 뽑으면 맨 뒤부터 먹을 경우 맨끝 - 처음 - 처음 +1 - 처음+2 
		// N+k-1 개만큼 갖는다
		for (int i = N, j = 0; i < N+k-1; i++,j++) {
			arr[i] = arr[j];
		}
		//System.out.println(Arrays.toString(arr));
		// 시작 범위는 배열 길이-먹을 초밥 개수 = 시작인댁스 최대값
		for (int i = 0; i < (N+k-1)-k; i++) {
			// i부터 k개 먹을 반복문
			for (int j = i; j < i+k; j++) {
				if (susi[arr[j]] == 0) {
					susi[arr[j]]++;
					Nzero++;
				}
				else {
					susi[arr[j]]++;
				}
				
			}
		}
		
	}
}
