package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S2_2075_N번째큰수 {
    static int n;
    static PriorityQueue<Integer> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int res = 0;
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                q.add(Integer.parseInt(st.nextToken()));
            }

        }
//        System.out.println(q);
        int cnt = 1;
        while(!q.isEmpty()) {
            if(cnt == n) {
                System.out.println(q.poll());
                return;
            }else {
                q.poll();
                cnt++;
            }
        }

    }
}
