package com.ssafy.ws.BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_21278_호석이두마리치킨 {
    static int N, M;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //건물
        M = Integer.parseInt(st.nextToken()); //도로
        arr = new int[N + 1][N + 1];
        for (int i = 1; i < M + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                if (i != j && arr[i][j] == 0) {
//                  이거 왜 10만이지??
                    arr[i][j] = 100000;
                }
            }
        }
//        System.out.println(Arrays.deepToString(arr));
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i < arr.length; i++) {
                for (int j = 1; j < arr.length; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
//        System.out.println(Arrays.deepToString(arr));

        int minSum = Integer.MAX_VALUE;
        int[] res = new int[3];
        //치킨집 2개 정하고 건물 거리 총합 구해야함
        //첫번째 치킨집
        for (int i = 1; i < arr.length; i++) {
            //두번째 치킨집
            for (int j = i + 1; j < arr.length; j++) {
                int sum = 0;
                //방문할 건물
                for (int k = 1; k < arr.length; k++) {
                    sum += Math.min(arr[i][k], arr[j][k]);
                }
                if (minSum > sum) {
                    minSum = sum;
                    res[0] = i;
                    res[1] = j;
                    res[2] = sum*2;

                }
            }
        }
//        System.out.println(Arrays.toString(res));
        System.out.printf("%d %d %d",res[0],res[1],res[2]);
    }
}
