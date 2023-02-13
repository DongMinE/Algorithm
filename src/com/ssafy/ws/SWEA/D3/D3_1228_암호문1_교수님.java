package com.ssafy.ws.SWEA.D3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class D3_1228_암호문1_교수님 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/sw-input1225.txt"));

		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			sc.nextLine();
			List<String> l = new LinkedList<>(Arrays.asList(sc.nextLine().split(" ")));
			sc.nextLine();
			String[] cmd = sc.nextLine().split(" ");
			for (int k = 0; k < cmd.length;) {
				int loc = Integer.parseInt(cmd[++k]);
				int cnt = Integer.parseInt(cmd[++k]);
				for (int j = cnt; j >0; j--) {
				l.add(loc, cmd[k + j]);
				}
				k += cnt + 1;
			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < 10; i++) System.out.print(l.get(i)+ " ");
			System.out.println();
		}
	}

}
