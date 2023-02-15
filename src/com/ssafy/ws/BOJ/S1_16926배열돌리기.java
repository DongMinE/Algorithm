package com.ssafy.ws.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_16926배열돌리기 {
	static int[][] board;
    static int n, m, r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < r; i++) {
            rotation();
        }
        for (int[] row : board){
            Arrays.stream(row).forEach(num -> System.out.print(num + " "));
            System.out.println();
        }
    }

    static void rotation() {
        int[] dx = {0, 1, 0, -1}; // → ↓ ← ↑
        int[] dy = {1, 0, -1, 0};
        for (int i = 0; i < Math.min(m, n) / 2; i++) {
            int d = 0; // 초기 방향
            int x = i;
            int y = i;

            int first = board[i][i]; // 덮어씌운 후 마지막을 위함
            while (true) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (i <= nx && nx < n - i && i <= ny && ny < m - i) {
                
                    board[x][y] = board[nx][ny];

                    x = nx;
                    y = ny;
                }
                else {
                    d++;
                    if (d == 4) {
                        break;
                    }
                }
            }
            board[i+1][i] = first;
            System.out.println(first);
        }
    }
}
