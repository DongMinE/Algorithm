package com.ssafy.ws.BOJ.Gold;

import java.io.*;
import java.util.*;

public class G4_9019_DSLR {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Queue<Integer> q = new ArrayDeque<>(); //현재숫자 넣을 큐
            String[] res = new String[10000]; //정답넣을 배열
            Arrays.fill(res, ""); //정답배열 초기화
            boolean[] check = new boolean[10000]; //방문처리 배열

            q.add(a);
            check[a] = true;

            while (!check[b] && !q.isEmpty()) {
                int current = q.poll();

                int D = (2 * current) % 10000;
                int S = (current == 0) ? 9999 : current - 1;
                int L = (current % 1000) * 10 + current / 1000;
                int R = (current % 10) * 1000 + current / 10;

                if (!check[D]) {
                    q.add(D);
                    check[D] = true;
                    res[D] = res[current] + "D";
                }
                if (!check[S]) {
                    q.add(S);
                    check[S] = true;
                    res[S] = res[current] + "S";
                }
                if (!check[L]) {
                    q.add(L);
                    check[L] = true;
                    res[L] = res[current] + "L";
                }
                if (!check[R]) {
                    q.add(R);
                    check[R] = true;
                    res[R] = res[current] + "R";
                }
            }
            sb.append(res[b]).append("\n");
        }
        System.out.println(sb);

    }

    private static int O(String alpha, int current, StringBuilder sb) {
        if (alpha.equals("D")) {
            current *= 2;
            if (current > 9999) {
                current %= 10000;
            }
            return current;
        } else if (alpha.equals("S")) {
            current -= 1;
            if (current == 0) {
                current = 9999;
            }
            return current;
        } else if (alpha.equals("L")) {
            current = (current % 1000) * 10 + current / 1000;
            return current;
        } else if (alpha.equals("R")) {
            current = (current % 10) * 1000 + (current / 10);
            return current;
        }

        return current;
    }

}
