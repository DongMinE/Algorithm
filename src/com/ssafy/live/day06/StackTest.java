package com.ssafy.live.day06;

public class StackTest {

	public static void main(String[] args) {
		
		//IStack<String> stack = new LinkedListStack<String>();
		LinkedListStack<String> stack = new LinkedListStack<String>();
		stack.push("강수민");
		stack.push("전임송");
		stack.push("박정은");
		stack.push("송진현");
		stack.push("임준성");
		stack.push("빅지환");
		stack.push("양유진");
		stack.push("박상진");
		
		System.out.println(stack.size() + "//" + stack.isEmpty());
		//System.out.println(stack.peek());
		System.out.println(stack.top.toString());
		System.out.println(stack.size() + "//" + stack.isEmpty());
		System.out.println(stack.peek());
		System.out.println(stack.size() + "//" + stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
