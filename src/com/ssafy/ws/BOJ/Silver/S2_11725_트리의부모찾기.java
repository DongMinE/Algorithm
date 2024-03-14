package com.ssafy.ws.BOJ.Silver;

import java.io.*;
import java.util.*;
import javax.swing.plaf.FontUIResource;

public class S2_11725_트리의부모찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tree.get(x).add(y);
            tree.get(y).add(x);
        }

        boolean[] check = new boolean[n + 1];
        int[] res = new int[n + 1];

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        check[1] = true;

        while (!q.isEmpty()) {
            int number = q.poll();
            for (int chil : tree.get(number)) {
                if (!check[chil]) {
                    check[chil] = true;
                    q.add(chil);
                    res[chil] = number;
                }
            }
        }

        for (int i = 2; i < n + 1; i++) {
            System.out.println(res[i]);
        }

    }
}
