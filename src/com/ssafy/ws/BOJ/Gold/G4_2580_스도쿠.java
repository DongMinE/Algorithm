package com.ssafy.ws.BOJ.Gold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class G4_2580_스도쿠 {
	static int T, N;
	static int[][] map = new int[9][9];
	static int Ans;
	static class Point{
		int r,c;
		Point(int r, int c){
			this.r=r;
			this.c=c;
		}
	}
	static ArrayList<Point>list = new ArrayList();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==0) {
					list.add(new Point(i, j));
				}
			}
		}
		
		//print(map);
		recursive(0);
	}
	
	private static void recursive(int idx) {
		// basis part
		if(idx==list.size()) {
			print(map);
			//System.out.println("------------------");
			System.exit(0);
		}
		
		// inductive part\
		Point p = list.get(idx);
		int r = p.r;
		int c = p.c;
		
		for (int i = 1; i <= 9; i++) {
			if(check(r,c,i)) {
				map[r][c]=i;
				recursive(idx+1);
				map[r][c]=0;
			}
		}
	}

	private static boolean check(int r, int c, int num) {
		// 가로 세로 검사
		for (int i = 0; i < 9; i++) {
			if(map[r][i]==num||map[i][c]==num) return false;
		}
		
		int Sr = (r/3)*3;
		int Sc = (c/3)*3;
		// squre
		for (int i = Sr; i < Sr+3; i++) {
			for (int j = Sc; j < Sc+3; j++) {
				if(map[i][j]==num) return false;
			}
		}
		
		return true;
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
