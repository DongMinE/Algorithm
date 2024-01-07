package com.ssafy.ws.SWEA.Battle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 동계대학생_24년도_1번 {

    static List<Integer>[] graph;
    static List<Integer> list;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        //n번째 층의 오른쪽 끝 수를 판단하는 배열
        list = new ArrayList<>();
        list.add(0); // 편의상 0번 노드는 0 넣음
        int floor = 1; //층 수 저장
        int currentNum = 0; //현재 숫자

        while (currentNum <= 10000) {
            currentNum = floor * (floor + 1) / 2;
            list.add(currentNum);
            floor++;
        }

        //10001짜리 완성된 노드 만들어두기
        graph = new ArrayList[10001];
        int cnt = 2;

        //0번째 노드 null이 아니게 0 넣어줌
        graph[0] = new ArrayList<>();
        graph[1] = new ArrayList<>();
        graph[0].add(0);
        graph[1].add(2);
        graph[1].add(3);
        //진짜 연결된 숫자들 넣어줌
        for (int i = 2; i <= 10000; i++) {
            graph[i] = new ArrayList<>();
            //제일 왼쪽 이면 3개 추가
            if (i == list.get(cnt) - (cnt - 1)) {
                graph[i].add(i + 1);
                graph[i].add(i + cnt);
                graph[i].add(i + cnt + 1);
                //제일 오른쪽이다 3개 추가, 층 수 추가
            } else if (i == list.get(cnt)) {
                graph[i].add(i - 1);
                graph[i].add(i + cnt);
                graph[i].add(i + cnt + 1);
                cnt++;
                //제일 왼쪽도 오른쪽도 아니다 4개
            } else {
                graph[i].add(i - 1);
                graph[i].add(i + 1);
                graph[i].add(i + cnt);
                graph[i].add(i + cnt + 1);
            }
        }
//        System.out.println(Arrays.toString(graph));
        //테스트 시작
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int res = bfs(Math.min(s, e), Math.max(s, e));
            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs(int start, int target) { //현재노드, 소모한 삼각김밥 갯수
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[10001];

        q.offer(new int[]{start, 0});  //시작 노드, 소모한 갯수 0부터 시작

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            //cur는 0번이 현재노드, 1번이 카운팅 된 삼각김밥 갯수니까 0번으로 방문 체크
            if (visited[cur[0]]) {
                continue; // 이미 방문했으면 다음
            }
            visited[cur[0]] = true;

            //현재 꺼낸 노드가 목표 숫자라면 꺼내
            if (cur[0] == target) {
                return cur[1];
            }

            //현재 노드가 목표숫자가 아니라면 큐에 추가
            for (int i = 0; i < graph[cur[0]].size(); i++) {
                int next = graph[cur[0]].get(i); //현재 노드에 연결된 숫자들 꺼내기
                if (next >= 10001) {
                    continue;
                }
                if (!visited[next]) {
                    q.offer(new int[]{next, cur[1] + 1});
                }
            }
        }

        return -1;
    }
}