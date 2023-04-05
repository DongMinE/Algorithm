package com.ssafy.ws.SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author taeheekim
*/
public class D4_5643_키순서_Memo_김태희 {

	static int N,M,adj[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine().trim());
		for(int tc=1; tc<=TC; ++tc) {
			N = Integer.parseInt(in.readLine());
			M = Integer.parseInt(in.readLine());
			adj = new int[N + 1][N + 1];// 0행, 0열 메모 목적으로 1씩 크기 늘림 (각행 0열 : 자신보다 큰 대상 개수, 0행 각열 : 자신보다 작은 대상  개수)
			
			for (int i = 0; i <= N; ++i) adj[i][0] = -1;

			for (int m = 0; m < M; ++m) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				adj[i][j] = 1;
			}
			int answer = 0;
			for (int k = 1; k <= N; ++k) {
				if (adj[k][0] == -1) gtDfs(k);
			}

			for (int i = 1; i <= N; ++i) {
				for (int j = 1; j <= N; ++j) {
					adj[0][j] += adj[i][j];
				}
			}
			for (int k = 1; k <= N; ++k) {
				if (adj[k][0] + adj[0][k] == N - 1) answer++;
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
	private static int gtDfs(int k) {
		int cnt = 0;
		for (int i = 1; i <= N; ++i) {
			if (adj[k][i] == 1) { // i가 나보다 크고 
				if (adj[i][0] == -1) // 아직 i가 i 자신 보다 큰 대상을 탐색하지 않았다면 탐색
					gtDfs(i);

				if (adj[i][0] > 0) { // 탐색 후 i보다 큰 대상이 존재하면 그 대상들은  결국 k보다도 큰 대상이 됨 
					for (int j = 1; j <= N; ++j)
						if (adj[i][j] == 1)// i보다 j가 크다면 결국 j는 k보다도 크게 됨. 따라서 인접행렬에 마킹 
							adj[k][j] = 1;
				}
			}
		}
		for (int j = 1; j <= N; ++j) // 탐색을 마친 후 자신보다 큰 대상들을 모두 카운트 
			if (adj[k][j] == 1) cnt++;
		
		return adj[k][0] = cnt; // 카운트 결과(자신보다 큰 대상의 개수)를 자신의 인접행렬 0열의 위치에 저장 
	}
}
