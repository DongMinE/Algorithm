package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_18111_마인크래프트 {

    static int n,m,b;
    static int[][] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        list = new int[n][m];
        //최대 높이
        int max = Integer.MIN_VALUE;
        //최소 높이
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int next = Integer.parseInt(st.nextToken());
                list[i][j] = next;
                if(min > next) min = next;
                if(max < next) max = next;
            }
        }
        //최소 시간, 블럭
        int minTime = Integer.MAX_VALUE;
        int minBlock = Integer.MAX_VALUE;
        for (int i = min; i <= max; i++) {
            //소모 시간 초기화
            int time = 0;
            //블럭 원래 갯수로 초기화
            int block = b;
            for (int k = 0; k < n; k++) {
                for (int l = 0; l < m; l++) {
                    int diff = list[k][l] - i;
                    //블럭을 쌓고, 인벤 -1
                    if (diff < 0) {
                        time -= diff;
                        block += diff;
                        //블럭을 캐고 인벤에 넣음 +1
                    }else{
                        time += 2*diff;
                        block += diff;
                    }
                }
            }
            if (block >= 0 && time <= minTime) {
                minTime = time;
                minBlock = i;

            }
        }

        System.out.println(minTime + " " + minBlock);


    }

}
