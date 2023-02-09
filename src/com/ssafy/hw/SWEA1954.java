package com.ssafy.hw;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA1954 {
	static int N;
	static int[][] board;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		board = new int[N][N];
		DFS(0, 0, 0, 1);
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	static void DFS(int r, int c, int v, int x) {
		if(x == N*N)
			return;
		board[r][c] = x;
		r = r - dr[v];
		c = c - dc[v];
		if(r < 0 || c < 0 || r >= N || c >= N || board[r][c] != 0) {
			r = r + dr[v];
			c = c + dc[v];
			v = (v+1)%4;
		}
		x++;
		DFS(r,c,v,x);
		
	}
	
}
