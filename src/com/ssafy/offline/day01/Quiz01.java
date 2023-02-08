package com.ssafy.offline.day01;

public class Quiz01 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		System.out.println(solve("korea",0)); // k,o,r,e,a
	}

	private static String solve(String str, int idx) {
		
		if(idx == str.length()) return sb.toString() ;

		if (idx < str.length()-1) {
			sb.append(str.charAt(idx)).append(',');
		}
		else if (idx == str.length()-1) {
			sb.append(str.charAt(idx));
		}
				
		
		return solve(str, idx+1);

	}

}
