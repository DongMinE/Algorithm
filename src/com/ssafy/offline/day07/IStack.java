package com.ssafy.offline.day07;

public interface IStack<T> {
	void push(T e);
	T pop();
	T peek();
	boolean isEmpty();
	int size();
}
