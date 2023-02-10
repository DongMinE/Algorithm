package com.ssafy.offline.day05;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class queueApiTest implements Comparable<Student> {
	@Override
	public int compareTo(Student o) {
		return this.age - o. age;
	}
	String name;
	int age;
		public Student(String name, int age) {
			this.name = name;
			this.age = age;
		}
	
	
	public static void main(String[] args) {
		Queue<String> q2 = new PriorityQueue<>();
		q2.offer(new Student("전경호", "전도연", 80));
		q2.offer(new Student("윤성빈", "김강민", 78));
		q2.offer(new Student("문동은", "유재석", 99));
		
		q2.offer("일타스캔들");
		q2.offer("피지컬 100");
		q2.offer("더글로리스2");
		System.out.println(q2.poll());
		System.out.println(q2.poll());
		System.out.println(q2.poll());
		
		
		
		Queue<String> q1 = new LinkedList<>();
		q1 = new ArrayDeque<>();
		System.out.println(q1.isEmpty() + " , " + q1.size());
		q1.offer("큐 연습");
		q1.offer("스택 연습");
		
		System.out.println(q1.poll());  // 데이터 꺼내기
		System.out.println(q1.isEmpty() + " , " + q1.size());
		
		System.out.println(q1.peek());  // 데이터 확인만
		System.out.println(q1.isEmpty() + " , " + q1.size());
		
	}
}
