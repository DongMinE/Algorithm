package com.ssafy.offline.day05;

import java.util.Stack;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class StackTest {
	public static void main(String[] args) {
		Stack<String> s = new Stack<>();
		System.out.println(s.isEmpty() + " : " + s.size());
		
		s.push("오");
		s.push("금");
		s.push("내");
		s.push("주");
		System.out.println(s.isEmpty() + " : " + s.size());
		
		System.out.println(s.pop());  // 데이터를 꺼내고 삭제
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.pop());
	}
}
