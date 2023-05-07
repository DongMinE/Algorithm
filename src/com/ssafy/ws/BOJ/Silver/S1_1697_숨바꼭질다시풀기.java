package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1_1697_숨바꼭질다시풀기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] time = new int[100001];
        Arrays.fill(time, -1);
        int second = 0;
        time[n] = second;

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(n);

        int[] rule = {-1, 1, 2};
        while (!q.isEmpty()) {
            int size = q.size();
            second++;
            for (int j = 0; j < size; j++) {
                int now = q.poll();
                for (int i = 0; i < 3; i++) {
                    int possible = (i == 2) ? now * 2 : now + rule[i];
                    if (possible < 0 || possible >= 100001) continue;
                    if(time[possible] == -1) {
                        q.offer(possible);
                        time[possible] = second;
                    }
                }
            }
            if (time[m] != -1) break;
        }
        System.out.println(time[m]);
    }
}

