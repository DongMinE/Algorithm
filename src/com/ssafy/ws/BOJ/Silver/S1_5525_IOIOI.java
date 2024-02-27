package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_5525_IOIOI {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String match = br.readLine();

        int cnt = 0, ans = 0;
        for (int i = 1; i < m - 1; ) {
            if (match.charAt(i) == 'O' && match.charAt(i + 1) == 'I') {
                cnt++;
                if (cnt == n) {
                    if (match.charAt(i - (cnt * 2 - 1)) == 'I') {
                        ans++;
                    }
                    cnt--;
                }
                i += 2;
            } else {
                i++;
                cnt = 0;
            }
        }
        System.out.println(ans);
    }
}
