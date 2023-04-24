package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_1912_연속합 {
		// 완탐으로는 어림도 없는 숫자의 양;;;;;
		// 메모이제이션배웠는데 할 줄 몰랐는데 이걸로 메모이제이션을.araboja
		
// 탑-다운 방식 
//		잘 모르곘음
//		static int recur(int N) {
//			 
//			// 탐색하지 않은 인덱스라면
//			if(dp[N] == null) {
//		 
//				// (이전 배열의 누적합 + 현재 값)과 현재 값을 비교하여 최댓값을 N위치에 저장
//				dp[N] = Math.max(recur(N - 1) + arr[N], arr[N]);
//				
//			}
//				
//			return dp[N];
//		}
		
// 바텀-업 이건 
//		똑같은 크기의 배열하나 더 만들어서 하나씩 더해서 이전 값 최대값 + 내 값 해서 최대값을 저장한다
//		for (int i = 1; i < N; i++) {
//			dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
//		}
//		
	static int n, res, arr[], memo[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		memo = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//System.out.println(Arrays.toString(arr));
		memoization();
		System.out.println(res);
	}
	private static void memoization() {
		memo[0] = arr[0];
		res = arr[0];
		
		for (int i = 1; i < n; i++) {
			//이전 메모이제이션 값+현재값  vs  현재값  의 최대 값 비교 저장
			//지금까지 더한거랑 기존의 최대랑 비교해서 최대를 뽑는 느낌은 알겠는데 왜 memo자체에는 최대가 안담기지...? 
			memo[i] = Math.max(memo[i-1]+arr[i], arr[i]);
			
			res = Math.max(res, memo[i]);
		}
	}
}








