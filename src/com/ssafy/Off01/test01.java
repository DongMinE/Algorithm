/*
 *  기저조건 : 재귀를 멈추는 조건
 *  
 *  자기자신을 호출하는 함수
 *  재귀와 반복은 서로 변환이 가능하다
 *  재귀함수는 콜스텍이 계속 쌓인다
 * 
 * 
 * 
 */

package com.ssafy.Off01;
public class test01 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("main");
		Thread.sleep(1000);
		main(null);
	}

}
