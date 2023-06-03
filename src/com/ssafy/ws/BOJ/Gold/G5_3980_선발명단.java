package com.ssafy.ws.BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_3980_선발명단 {
    static int maxSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            maxSum = 0;
            int[][] pos = new int[11][11];
            boolean[] check = new boolean[11];
            StringTokenizer st;
            for (int i = 0; i < 11; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    pos[i][j]  = Integer.parseInt(st.nextToken());
                }
            }
            bfs(pos, 0, check, 0); // 선수 점수, 총합, 자리체크, 선수 번호
            System.out.println(maxSum);
        }
    }

    private static void bfs(int[][] pos, int sum, boolean[] check, int player) {
        if (player == 11) {
            maxSum = Math.max(maxSum, sum);
            System.out.println(maxSum);
            return;
        }
        for (int i = 0; i < 11; i++) {
            if(pos[player][i] == 0 || check[i]) continue;
            check[i] = true;
            bfs(pos, sum+pos[player][i], check, player+1);
            check[i] = false;
        }
    }
}
