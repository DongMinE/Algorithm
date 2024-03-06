package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class S3_9375_패션왕신해빈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> list = new HashMap<>();

            while (n-- > 0) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String kind = st.nextToken();

                if (list.containsKey(kind)) {
                    list.put(kind, list.get(kind) + 1);
                } else {
                    list.put(kind, 1);
                }
            }
            int res = 1;

            for (int val : list.values()) {
                res *= (val + 1);
            }

            System.out.println(res - 1);
        }
    }
}
