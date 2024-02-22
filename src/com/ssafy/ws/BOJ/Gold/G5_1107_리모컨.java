package com.ssafy.ws.BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_1107_리모컨 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 목표 채널
        int n = Integer.parseInt(br.readLine());
        // 초기 값
        int ans = Math.abs(n - 100);
        // 고장 채털 개수
        int m = Integer.parseInt(br.readLine());
        boolean[] broken = new boolean[10];
        if (m == 0) {
            String num = Integer.toString(n);
            System.out.println(num.length());
            return;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 고장 버튼 참거짓
        for (int i = 0; i < m; i++) {
            broken[Integer.parseInt(st.nextToken())] = true;
        }
        for (int i = 0; i <= 999999; i++) {
            String cur = Integer.toString(i);
            boolean check = false;

            for (int j = 0; j < cur.length(); j++) {
                if(broken[cur.charAt(j) - '0']) {
                   check = true;
                   break;
                }
            }
            if(!check) {
              ans = Math.min(ans,cur.length() + Math.abs(n-i));
            }
        }
        System.out.println(ans);
    }
}
