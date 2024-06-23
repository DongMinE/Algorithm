package com.ssafy.ws.BOJ.Gold;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class G5_16928_뱀과사다리게임 {

    static int[] origin = new int[101];
    static int[] cnt = new int[101];
    static boolean[] check = new boolean[101];
    static int n, m;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            origin[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        sol();
    }

    private static void sol() {
        Queue<Integer> q = new ArrayDeque<>();

        q.add(1);
        cnt[1] = 0;
        check[1] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == 100) {
                System.out.println(cnt[cur]);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int x = cur + i;
                if (100 >= x && !check[x]) {
                    check[x] = true;

                    if (origin[x] != 0) {
                        if (!check[origin[x]]) {
                            q.offer(origin[x]);
                            check[origin[x]] = true;
                            cnt[origin[x]] = cnt[cur] + 1;
                        }
                    } else {
                        q.offer(x);
                        cnt[x] = cnt[cur] + 1;
                    }
                }
            }
        }
    }
}
