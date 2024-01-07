package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {

    int x, y, time;

    Node(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class 김동민_BOJ_17141_연구소2 {

    static int n, m, map[][], copymap[][], virusarr[];
    static int min = Integer.MAX_VALUE;
    static List<Node> virus = new ArrayList<>();
    static boolean visited[][], virusvisited[];
    static int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0};
    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        copymap = new int[n][n];
        map = new int[n][n];
        visited = new boolean[n][m];

        // 입력 받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    // 바이러스 위치랑 시간받은 node생성해서 넣기
                    virus.add(new Node(i, j, 0));
                }
            }
        }
        // 조합 돌릴 바이러스 방문처리
        virusvisited = new boolean[virus.size()];
        // 바이러스 조합뽑기 위한 조합 배열
        virusarr = new int[m];
        dfs(0, 0);
        // 갱신 안댔으면 -1, 됐으면 최소갑 출력
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    private static void dfs(int cnt, int start) {
        if (cnt == m) {
            bfs();
            return;
        }

        for (int i = start; i < virus.size(); i++) {
            if (!virusvisited[i]) {
                virusarr[cnt] = i;
                virusvisited[i] = true;
                dfs(cnt + 1, i + 1);
                virusvisited[i] = false;
            }
        }
    }

    private static void bfs() {
        max = -1;
        // 배열 복사하기
        copy();
        visited = new boolean[n][n];
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            // 큐에 바이러스 위치값 넣고 좌표만 따로 저장
            q.add(virus.get(virusarr[i]));
            int x = virus.get(virusarr[i]).x;
            int y = virus.get(virusarr[i]).y;
            // 조합에서 나온 좌표만 2로 변경
            copymap[x][y] = 2;
        }

        while (!q.isEmpty()) {
            Node a = q.poll();
            // 지연 시간 넣기
            max = Math.max(max, a.time);
            // 4방으로 퍼지기
            for (int i = 0; i < 4; i++) {
                int nx = a.x + dx[i];
                int ny = a.y + dy[i];
                // 배열 범위 벗어나는지 체크
                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    // 아직 방문을 하지 않았고 0으로 갈 수 있는 방향인지 체크
                    if (!visited[nx][ny] && copymap[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        copymap[nx][ny] = 2;
                        // 다음 퍼질 곳 넣고 큐 돌려
                        q.add(new Node(nx, ny, a.time + 1));
                    }
                }
            }
        }
        // 0이 남아있는지 체크
        if (isPossible()) {
            min = Math.min(min, max);
        }
    }

    private static boolean isPossible() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (copymap[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void copy() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 조합돌려서 나온 바이러스 위치만 2로 바꿔줄꺼니가 나머지는 0을 변경하기 위한 작업
                if (map[i][j] == 2) {
                    copymap[i][j] = 0;
                } else {
                    copymap[i][j] = map[i][j];
                }
            }
        }
    }
}
