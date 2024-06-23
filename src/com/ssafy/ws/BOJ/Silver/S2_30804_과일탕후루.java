package com.ssafy.ws.BOJ.Silver;

import java.io.*;
import java.util.*;

public class S2_30804_과일탕후루 {

    static List<Integer> list;
    static int n, sum;
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        check = new int[10];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            check[num]++;
            if (check[num] == 1) {
                sum++;
            }
            list.add(num);
        }
        if (sum <= 2) {
            System.out.println(list.size());
        }
        while (sum > 2) {
            int num = list.get(0);
            check(num, 0);
            if (sum == 2) {
                return;
            }
            num = list.get(list.size() - 1);
            check(num, list.size() - 1);
        }
    }

    private static int check(int k, int rem) {
        list.remove(rem);
        check[k]--;
        if (check[k] == 0) {
            sum--;
        }
        if (sum == 2) {
            System.out.println(list.size());
            return sum;
        }
        return -1;
    }
}
