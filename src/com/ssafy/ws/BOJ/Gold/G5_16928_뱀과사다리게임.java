package com.ssafy.ws.BOJ.Gold;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class G5_16928_뱀과사다리게임 {

    static int[] origin = new int[107];
    static Queue<Integer> q = new ArrayDeque<>();
    static int n, m;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            origin[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        sol(1);
    }

    private static void sol(int current) {
        q.add(current);

        if (current >= 100) {
            if (current == 100) {
                System.out.println(cnt);
            }
            return;
        }

        while (!q.isEmpty()) {
            int out = q.poll();

            for (int i = 1; i <= 6; i++) {
                cnt++;
                if (origin[current] != 0) {
                    current += origin[out];
                } else {
                    current += i;
                }
                sol(current);
            }
        }
    }
}
