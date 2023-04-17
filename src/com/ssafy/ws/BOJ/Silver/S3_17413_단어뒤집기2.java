package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S3_17413_단어뒤집기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuffer sb = new StringBuffer();
		Stack<Character> stack = new Stack<>();
		
		boolean check = false;
		
		for (int i = 0; i < s.length(); i++) {
			// "<"가 왔다!!
			if (s.charAt(i) == '<') {
				check = true;
				
				//새로운 괄호니까 앞에 쌓아 둔 스택의 글자들을 뽑아냄 
				//스택이니까 괄호에 쌓인 글자가 아닌 것들을 반대로 뽑아냄
				//while(!stack.isEmpty()) System.out.print(stack.pop());
				while(!stack.isEmpty()) sb.append(stack.pop());
				
				//다 뽑고 <로 시작
				//System.out.println(s.charAt(i));
				//System.out.print('<');
				sb.append('<');
			}
			// ">"가 왔다!!
			else if (s.charAt(i) == '>') {
				check = false;
				//괄호 끝났음
				//System.out.println(s.charAt(i));
				sb.append('>');
				
			}
			// check아 아직 true라는 것은 괄호 안에 있는 글자니까 그대로 출력
			//else if(check) System.out.print(s.charAt(i));
			else if(check) sb.append(s.charAt(i));
			
			else if(!check) {
				//공백이니까 다른글자가 온 것임
				//'<'와 마찬가지로 지금까지 쌓아둔 글자를 스택으로 뽑아냄
				if (s.charAt(i) == ' ') {
					//while(!stack.isEmpty()) System.out.print(stack.pop());
					while(!stack.isEmpty()) sb.append(stack.pop());
					
					//앞에 저장한 단어들 다 뽑고 공백 출력
					//System.out.print(s.charAt(i));
					sb.append(s.charAt(i));
				}
				
				//공백이 아니면 스택에 저장 
				else
				stack.push(s.charAt(i));
			}
			
		}
		// 끝까지 다 넣고 <>출력했으면 나머지 스택에 있는거 출력
		//while(!stack.isEmpty()) System.out.print(stack.pop());
		while(!stack.isEmpty()) sb.append(stack.pop());
		
		System.out.println(sb.toString());
	}
}
