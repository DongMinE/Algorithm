package com.ssafy.ws.BOJ.Silver;

import java.io.*;
import java.util.*;

public class S5_3063_게시판 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] list = new int[9];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 9; j++) {
                list[j] = Integer.parseInt(st.nextToken());
            }

            int row1 = list[3] - list[1];
            int col1 = list[4] - list[2];
            int widthA = row1 * col1;

            int leftX = Math.max(list[1], list[5]);
            int leftY = Math.max(list[2], list[6]);

            int rightX = Math.min(list[3], list[7]);
            int rightY = Math.min(list[4], list[8]);

            int row2 = rightX - leftX;
            int col2 = rightY - leftY;

            int widthB = 0;
            if (row2 > 0 && col2 > 0) {
                widthB = row2 * col2;
            }
            System.out.println(Math.max(widthA - widthB, 0));
        }

    }
}
