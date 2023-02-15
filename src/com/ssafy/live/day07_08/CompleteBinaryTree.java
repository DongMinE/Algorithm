package com.ssafy.live.day07_08;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class CompleteBinaryTree<T> {
	//제네릭을 이용해서 배열을 못만들기때문에 Object로 만듬
    private Object[] nodes;
    private final int SIZE;
    //마지막 까지 저장된 인덱스를 관리하기 위한 lastIndex
    private int lastIndex;
    
    public CompleteBinaryTree(int size) {
        super();
        SIZE = size;
        nodes = new Object[size+1];
    }
    
    //latindex가 size와 같으면 포화상태!
    private boolean isFull() {
        return  lastIndex == SIZE;
    }
    
    public void add(T e) {
        //만약에 가득찬 상태라면 못넣게 !
        if(isFull()) return;
        
        nodes[++lastIndex] = e;
    }
    
    public void bfs() {
        
        //쿠에는 탐색 노드의 번호 저장
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1); //루트 노드부터
        
        int current = 0, size, level =0;
        
        while(!queue.isEmpty()) {  //큐에 대기하고 있는 순서대로 노드 처리
            
            size = queue.size();    
            System.out.print("level " + level +" : ");
            
            while(--size >= 0) {
            
                current = queue.poll();  //현재 탐색하려는 노드 번호
                System.out.print(nodes[current]+ " ");
            
                // 현재 노드의 자식 노드들을 큐에 넣어 순서를 기다리게 하기!
                // 완전 이진 트리 : 자식이 최대 2개 !
                
                //왼쪽 자식
                if(current*2 <= lastIndex) queue.offer(current*2);
                if(current*2+1 <= lastIndex ) queue.offer(current*2+1); 
            }
            level++;
            System.out.println();
        }
        
    }
    
    
    public void dfsByPreOrder() {
        
        System.out.println("PreOrder : ");
        dfsByPreOrder(1);
        System.out.println();
    
    }
    
    private void dfsByPreOrder(int current) {
        System.out.print(nodes[current]+ " ");
        
        //왼쪽 자식
        if(current*2 <= lastIndex) dfsByPreOrder(current*2);
        //오른쪽 자식
        if(current*2+1 <= lastIndex ) dfsByPreOrder(current*2+1); 
    }
    
    
    public void dfsByInoder() {
        
        System.out.println("InOrder : ");
        dfsByInOrder(1);
        System.out.println();
    
    }
    
    
    private void dfsByInOrder(int current) {
        //왼쪽 자식
        if(current*2 <= lastIndex) dfsByPreOrder(current*2);
        System.out.print(nodes[current]+ " ");
        //오른쪽 자식
        if(current*2+1 <= lastIndex ) dfsByPreOrder(current*2+1); 
    }
    
    public void dfsByPostOrder() {
        
        System.out.println("PostOrder : ");
        dfsByPostOrder(1);
        System.out.println();
    
    }
    
    private void dfsByPostOrder(int current) {
        if(current > lastIndex) return;
        //왼쪽 자식
        dfsByPreOrder(current*2);
        //오른쪽 자식
        dfsByPreOrder(current*2+1);
        
        System.out.print(nodes[current]+ " ");
    }
    
    
    public void dfs() {
        
        //쿠에는 탐색 노드의 번호 저장
        Stack<Integer> stack = new Stack<>();
        stack.push(1); //루트 노드부터
        
        int current = 0;
        
        while(!stack.isEmpty()) {  //큐에 대기하고 있는 순서대로 노드 처리
            
            current = stack.pop();  //현재 탐색하려는 노드 번호
            System.out.print(nodes[current]+ " ");
            // 현재 노드의 자식 노드들을 큐에 넣어 순서를 기다리게 하기!
            // 완전 이진 트리 : 자식이 최대 2개 !
            
            //오른쪽 자식
            if(current*2+1 <= lastIndex ) stack.push(current*2+1);
            //왼쪽 자식
            if(current*2 <= lastIndex) stack.push(current*2);
             
        }
        System.out.println();
    }
        
}
