package com.ssafy.ws.BOJ.Gold;

import java.util.*;
import java.io.*;

public class G4_1043_거짓말 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int res = Integer.parseInt(st.nextToken());

        boolean[] list = new boolean[n + 1]; // 사람 번호 뱌열
        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());

        //참가할 파티 배열
        List<int[]> party = new ArrayList<>();
        //참가 못할 사람이 포함된 파티 큐
        Queue<Integer> q = new ArrayDeque<>();
        //알고 있는 사람은 true처리
        for (int i = 0; i < size; i++) {
            int know = Integer.parseInt(st.nextToken());
            //진실을 안다면 명단에 true처리
            list[know] = true;
            q.add(know);
        }
        //리스트에 파티개수 만큼 배열 추가
        for (int i = 0; i < res; i++) {
            st = new StringTokenizer(br.readLine());
            int partyNum = Integer.parseInt(st.nextToken());
            int[] current = new int[partyNum];
            for (int j = 0; j < partyNum; j++) {
                current[j] = Integer.parseInt(st.nextToken());
            }
            party.add(current);
        }
        //알고있는 사람이 포함된 파티가 있다면 몰랐던 사람도 명단에 true처리
        while (!q.isEmpty()) {
            for (int[] a : party) {
                for (int i = 0; i < a.length; i++) {
                    if (q.contains(a[i])) {
                        for (int j = 0; j < a.length; j++) {
                            if (!list[a[j]]) {
                                list[a[j]] = true;
                                q.add(a[j]);
                            }
                        }
                    }
                }
            }
            q.poll();
        }
        //파티마다 진실을 아는 사람이 있다면 파티참가 수에서 -1, 다음 파티 검사
        for (int[] a : party) {
            for (int i = 0; i < a.length; i++) {
                if (list[a[i]]) {
                    res--;
                    break;
                }
            }
        }
//        System.out.println(Arrays.toString(list));
        System.out.println(res);
    }

}
