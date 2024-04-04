package com.ssafy.ws.BOJ.Gold;

import java.io.*;
import java.util.*;

public class G4_7662_이중우선순위큐 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treemap = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                // 삽입 연산
                if (st.nextToken().equals("I")) {
                    int num = Integer.parseInt(st.nextToken());
                    treemap.put(num, treemap.getOrDefault(num, 0) + 1);
                }
                // 삭제 연산
                else {
                    int num = Integer.parseInt(st.nextToken());
                    if (num == 1) {
                        if (treemap.isEmpty()) {
                            continue;
                        }
                        int value = treemap.get(treemap.lastKey());
                        if (value == 1) {
                            treemap.remove(treemap.lastKey());
                        } else {
                            treemap.put(treemap.lastKey(), value - 1);
                        }
                    } else {
                        if (treemap.isEmpty()) {
                            continue;
                        }
                        int value = treemap.get(treemap.firstKey());
                        if (value == 1) {
                            treemap.remove(treemap.firstKey());
                        } else {
                            treemap.put(treemap.firstKey(), value - 1);
                        }
                    }
                }
            }
            if (treemap.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(treemap.lastKey() + " " + treemap.firstKey());
            }
            for (Map.Entry<Integer, Integer> i : treemap.entrySet()) {
                System.out.println("key: " + i.getKey() + "val: " + i.getValue());
            }
        }
    }
}