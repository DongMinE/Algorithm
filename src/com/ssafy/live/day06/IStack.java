package com.ssafy.live.day06;

public interface IStack<T> {
	void push(T e);
	T pop();
	T peek();
	boolean isEmpty();
	int size();

}
