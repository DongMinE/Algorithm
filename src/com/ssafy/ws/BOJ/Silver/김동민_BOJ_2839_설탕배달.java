package com.ssafy.ws.BOJ.Silver;

import java.util.Scanner;

public class 김동민_BOJ_2839_설탕배달 {
	static int total;
//	static int res;
	static int res = 1700;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		total = sc.nextInt();
//		res = 0;
//		while (true) {
//			if (total % 5 == 0) {
//				res += total / 5;
//				break;
//			}
//			if (total % 5 != 0) {
//				total -= 3;
//				res += 1;
//			}
//			if (total < 0) {
//				res = -1;
//				break;
//			}
//		}
//		System.out.println(res)
//	}
//}

		 solve(0,0,0);
		 if (res == 1700) res = -1;
		 System.out.println(res);
	}

	private static void solve(int idx1, int idx2, int sum) {
		if (res != 1700) return;
							// 5키로 개수, 3키로 개수,  총 개수
		if ((idx1*5)+(idx2*3) > total) 
			return;			// 총 무게보다 넘어가면 리턴
		
		if ((idx1*5)+(idx2*3) == total) {
			sum = idx1 + idx2; // 맞아 떨어지면 sum에 저장
			if (sum < res)	   // 근데 총 개수가 지금 res보다 작을 때만 
				res = sum;	   // res에 새로 저장
			return;
		}
		solve(idx1+1, idx2, sum+1);
		solve(idx1, idx2+1, sum+1);
	}
}
