package com.ssafy.ws.BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class G5_10026_적록색약Re {

    static char[][] oriList, copyList;
    static boolean[][] check;
    int resRGB, res = 0;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        oriList = new char[n][n];
        copyList = new char[n][n];
        check = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String color = br.readLine();
            for (int j = 0; j < n; j++) {
                char RGB = color.charAt(j);
                oriList[i][j] = RGB;
                if (RGB == 'R') {
                    RGB = 'G';
                }
                copyList[i][j] = RGB;
            }
        }
//        for (char[] arr : oriList) {
//            System.out.println(Arrays.toString(arr));
//        }
//        System.out.println();
//        for (char[] arr : copyList) {
//            System.out.println(Arrays.toString(arr));
//        }
        //색 구역 확인
        bfs(oriList, check);
        bfs(copyList, check);
    }

    private static void bfs(char[][] colorArray, boolean[][] checkRGB) {
        Queue<Character> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

            }
        }
    }
}
