package com.ssafy.hw;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 김동민_BOJ_2164_카드2 {
		static int N;

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        N = sc.nextInt();
	        //큐생성
	        Queue<Integer> q = new LinkedList<>();
	        for (int i = 1; i < N+1; i++) {
	        	// i 큐 넣고
	            q.offer(i);
	        }
	        //n까지 반복할껀데 남은 카드가 1이 아닐때까지 
	        while (q.size() != 1) {
	        	//한장 빼고
	            q.poll();
	            //그 다음카드 빼서 위에 새로 넣기를 반복
	            int tmp = q.poll();
	            q.offer(tmp);
	 
	        }

	        System.out.println(q.peek());
	    }
	}

