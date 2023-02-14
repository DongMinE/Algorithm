package com.ssafy.live.day07;

import java.util.Arrays;

public class CompleteBinaryTreeTest {

	public static void main(String[] args) {

		int size = 9;
		
		CompleteBinaryTree<Character> tree = new CompleteBinaryTree<>(size);
		
		for (int i = 0; i < size; i++) {
			tree.add((char)(65+i));
		}
		tree.bfs();
		//System.out.println(tree.toString());
	}

}
