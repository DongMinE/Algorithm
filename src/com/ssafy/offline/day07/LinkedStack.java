package com.ssafy.offline.day07;

import com.ssafy.live.day06.Node;

public class LinkedStack<E> implements IStack<E> {
	
	public static void main(String[] args) {
		LinkedStack<Integer> s = new LinkedStack<>();
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println(s.size());
		System.out.println(s.top.toString());
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
	
	
	Node<E> top;
	
	class Node<T> {
		T data;
		Node<T> link;

		public Node(T data, Node<T> link) {
			super();
			this.data = data;
			this.link = link;
		}
		
		@Override
		public String toString() {
			return "Node [data=" + data + ", link=" + link + "]";
		}
	}

		@Override  
		public void push(E data) {
			// top으로 삽입
			top = new Node<>(data, top);
		}

		@Override
		public E pop() {
			if (isEmpty()) {
				System.out.println("공백스택이어서 불가능 합니다.");
				return null;
			}

			Node<E> res = top;
			top = top.link;
			res.link = null;
			return res.data;
		}

		@Override
		public E peek() {
			return top.data;
		}

		@Override
		public boolean isEmpty() {
			return top == null;
		}

		@Override
		public int size() { // top부터 노드 따라가서 마지막 노드까지의 수
			int res = 0;
			Node<E> node = top; 
			while (node != null) {
				res++;
				node = node.link;
		}
			return res;
	}
}
