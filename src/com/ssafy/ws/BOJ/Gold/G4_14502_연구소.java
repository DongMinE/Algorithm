package com.ssafy.ws.BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_14502_연구소 {

    static int[][] list;
    static boolean[] check;
    static ArrayList<int[]> zero;
    static int[][] virus = new int[3][2];
    static int shall = 0;
    static int n, m;
    static int[] nx = new int[]{0, 0, 1, -1};
    static int[] ny = new int[]{-1, 1, 0, -0};
    static Queue<int[]> q = new ArrayDeque<>();
    static int resSafeCnt = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 원본배열
        list = new int[n][m];
        // 0이 담긴 좌표 배열
        zero = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
                if (list[i][j] == 0) {
                    zero.add(new int[]{i, j});
                }
            }
        }
        check = new boolean[zero.size()];

        comb(0, 0);

        System.out.println(resSafeCnt);
    }

    private static void comb(int idx, int cnt) {
        if (cnt == 3) {
            //정해진 위치 3개를 갖고 바이러스 퍼지기 시작
            spread(virus);
        } else {
            for (int i = idx; i < zero.size(); i++) {
                virus[cnt] = zero.get(i);
                list[virus[cnt][0]][virus[cnt][1]] = 1;
                comb(i + 1, cnt + 1);
                list[virus[cnt][0]][virus[cnt][1]] = 0;
            }
        }
    }

    // 바이러스 퍼뜨려
    private static void spread(int[][] virus) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (list[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }
        int copyList[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            copyList[i] = list[i].clone();
        }

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int dx = nx[i] + x;
                int dy = ny[i] + y;

                if (dx >= 0 && dx < n && dy >= 0 && dy < m) {
                    if (copyList[dx][dy] == 0) {
                        copyList[dx][dy] = 2;

                        q.add(new int[]{dx, dy});
                    }
                }
            }
        }
//        for (int[] arr : copyList) {
//            System.out.println(Arrays.toString(arr));
//        }
//        System.out.println("----------------------------------");
        safeZone(copyList);

    }

    private static void safeZone(int[][] copyList) {
        int safeCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyList[i][j] == 0) {
                    safeCnt++;
                }
            }
        }
        if (safeCnt > resSafeCnt) {
            resSafeCnt = safeCnt;
        }
    }
}
