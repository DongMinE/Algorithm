package com.ssafy.ws.SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_5643_키순서_교수님Floyid {
	static int N, M, adj[][], cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			adj = new int[N+1][N+1];
			
			StringTokenizer st = null;
			int a, b;
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				adj[a][b] = 1;
			}
			for (int k = 1; k <= N; k++) { //경유 (학생 k)
				for (int i = 1; i <= N; i++) { // 출발 (학생 i)
					if(i==k || adj[i][k] == 0) continue; // 경유 효과 없음(알수 있는 관계 없음), i와 k와의 관계가 없어 경유 불가
					for (int j = 1; j <= N; j++) { //도착 (학생 j)
						// i << j : 학생 i보다 학생 k가 키가 크고 학생 k보다 학생 j가 키가 크면  학생 i보다 학생j가 키가 크다
						if(adj[i][j] == 1) continue; // 이미 i가 j보다  크다는 사실관계를 알면 패스
							adj[i][j] = adj[k][j];
					}
				}

			}
			int ans = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					adj[i][0] += adj[i][j]; //자신보다 키카 큰 학생 수 누적
					adj[0][j] += adj[i][j]; //자신보다 키카 작은 학생 수 누적
				}
				
			}
			for (int i = 1; i <= N; i++) {
				if (adj[i][0] + adj[0][i] == N -1) ans++;
			}

			System.out.println("#" + tc + " " + ans);
		}
	}

}
