package com.ssafy.ws.SWEA.CompetencyTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 김동민_SWEA_4012_요리사 {
	static int[] plan, price;
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            price = new int[4]; // 1일, 1달, 3달, 1년
            plan = new int[12]; // 1년 계획표
            res = Integer.MAX_VALUE;

            for (int i = 0; i < 4; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println(Arrays.toString(price));
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 12; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }
    
            check(0, 0); // 월, 누적 값

            res = Math.min(res, price[3]); // 연간 회원권이랑 비교

            sb.append("#").append(t).append(" ").append(res);
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

        // 완전탐색 (3^12) 
        static void check(int m, int total) {
            if (m > 11) { // 기저조건
                res = Math.min(res, total);
                return;
            }

            if (plan[m] == 0) { // 가지 살짝 치기
                check(m+1, total);
            } else {
                check(m+1, total + plan[m] * price[0]);
                check(m+1, total + price[1]);
                check(m+3, total + price[2]);
            }
        }
}
