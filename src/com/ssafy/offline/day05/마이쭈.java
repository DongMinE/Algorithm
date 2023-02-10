package com.ssafy.offline.day05;

import java.util.LinkedList;
import java.util.Queue;

public class 마이쭈 {
	static int myzzu = 20;
	static int people = 1;
	static int have = 1;
	static Queue<Integer> q1;

	public static void main(String[] args) {

		q1 = new LinkedList<>();

		Que(20, 1, 1);
	}

	private static void Que(int remyzzu, int people, int have) {
		while (remyzzu > 0) {
			q1.offer(people);
			q1.offer(have);

			people = q1.poll();
			System.out.print(people + "번이 ");
			people++;

			have = q1.poll();
			System.out.print(have + "개만큼 가져갑니다. \n");
			have++;

			remyzzu -= have;
			Que(remyzzu, people, have);
		}
	}

}
