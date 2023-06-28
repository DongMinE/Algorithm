package com.ssafy.ws.BOJ.Silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2_15666_n과m_12 {
    static int[] arr, res;
    static Integer[] arr2;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        arr = new int[n]; //원본 배열
        Set<Integer> tSet = new TreeSet<Integer>(); //중복없는 배열
        int inputInt = 0; //중복없이 set 배열에 넣을 입력값

        for (int i = 0; i < n; i++) {
            inputInt = Integer.parseInt(st.nextToken());
            tSet.add(inputInt); //트리셋에 추가하기
        }
        arr2 = tSet.toArray(new Integer[0]); // 트리셋을 배열로 변환(크기 0 으로 주면 알아서 트리셋배열만큼 배열 만듬
        int size = arr2.length;
        res = new int[m]; //정답 배열
        bfs(size,m,0, 0); //중복순열? size의 개수중에 m개를 뽑을꺼야
        System.out.println(sb.toString());
    }

    private static void bfs(int size,int m, int cnt, int start) {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                sb.append(res[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < size; i++) {
            res[cnt] = arr2[i];
            bfs(size,m,cnt+1,i);
        }
    }
}
