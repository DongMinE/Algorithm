package com.ssafy.ws.BOJ;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_6987_월드컵 {
	static int win, lose, draw, arr[], ans, drawTeam;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/TEST.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		arr = new int[18];
		for (int tc = 1; tc <= 4; tc++) {
			win = 0;
			draw = 0;
			lose = 0;
			ans = 1;
			st = new StringTokenizer(br.readLine());
			for (int o = 0; o < 18; o++) {
				arr[o] = Integer.parseInt(st.nextToken());
				if (o == 0) win += arr[o];			 //일단 0번쨰는 이긴거 더해주고
				else if ( o % 3 == 0) win += arr[o]; //나머지 0은 이긴거고
				else if ( o % 3 == 1) {				//나머지 1은 비긴거고
					draw += arr[o]; 				// 비긴 경기수랑 비긴 팀수도 저장
					if (arr[o] > 0) drawTeam++;		
				}
				else if ( o % 3 == 2) lose += arr[o]; //나머지 2는 진팀 
			}

			
			if (draw%2 == 0 || draw%2 != 0) {	//진 경기가 짝수인데 진팀이 홀 수면 불가능
				if (drawTeam%2 != 0) ans = 0;	//진 경기가 홀수인데 진팀이 홀 수면 불가능
			}
			if (win != lose) ans = 0;			// 이긴경기 수와 진 경기 총 수가 같아야함
			sb.append(ans).append(" ");
		}
		System.out.println(sb);

	}

}
