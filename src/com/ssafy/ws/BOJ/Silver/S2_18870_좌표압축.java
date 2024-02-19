package com.ssafy.ws.BOJ.Silver;

import java.io.*;
import java.util.*;

public class S2_18870_좌표압축 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        //랭크 매일 해쉬 맵
        HashMap<Integer, Integer> map = new HashMap<>();
        //원본배열
        int[] list = new int[n];
        //원본 배열에 삽입
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            list[i] = input;
        }
        //배열 카피
        int[] copyList = Arrays.copyOf(list, list.length);
        //카피 배열 정렬
        Arrays.sort(copyList);
        //맵에 정렬된 리스트의 숫서 키값 삽입
        int rank = 0;
        for (int key : copyList) {
            if (!map.containsKey(key)) {
                map.put(key, rank);
                rank++;

            }
        }
        for (Integer key : list) {
            sb.append(map.get(key)).append(" ");
        }
        System.out.println(sb);
    }
}
