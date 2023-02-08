package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1244 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[T];
		// 초기 스위치 배열
		for (int i = 0; i < T; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 학생수
		int stuNum = Integer.parseInt(br.readLine());
		for (int i = 0; i < stuNum; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			// 남학생
			if (sex == 1) {
				for (int j = 0; j < T; j++) {
					// 뽑은 수의 배수 위치에 있는 스위치의 상태를 바꾼다.
					if ((j + 1) % start == 0)
						arr[j] = arr[j] == 0 ? 1 : 0;
				}
			}
//			if (stuArr[sex][0] == 1) {
//			
//			int multi = stuArr[sex][1];
//			int start = stuArr[sex][1] - 1;
//			while (start < T) {
//				if (arr[start] == 1) {
//					arr[start] = 0;
//					start += multi;
//					System.out.println("4" + Arrays.toString(arr));
//
//				}
//				else if (arr[start] == 0) {
//					arr[start] = 1;
//					start += multi;
//					System.out.println("5" + Arrays.toString(arr));
//
//				}
//			}
//		}
//	}
			// 여학생
			else {
				// 뽑은 수를 중심으로 좌우가 대칭이면 상태를 바꾼다.
				arr[start - 1] = arr[start - 1] == 0 ? 1 : 0;
				for (int j = 1; j < T / 2; j++) {
					if (start - 1 + j >= T || start - 1 - j < 0)
						break;
					if (arr[start - 1 - j] == arr[start - 1 + j]) {
						arr[start - 1 - j] = arr[start - 1 - j] == 0 ? 1 : 0;
						arr[start - 1 + j] = arr[start - 1 + j] == 0 ? 1 : 0;
					} else
						break; // 대칭 아닌것이 나오면 바로 끝낸다.
				}
			}
			
		}
//		else(stuArr[sex][0] == 2) {
//		int start = stuArr[sex][1] - 1;
//		if(sex == 1) {
//			for(int j=0; j<T; j++) //뽑은 수의 배수 위치에 있는 스위치의 상태를 바꾼다.
//				if((j+1) % start == 0)
//					arr[j] = arr[j] == 0? 1: 0;
//		}
//		if (arr[start] == 1) {
//			arr[start]--;
//		}
//		else if (arr[start] == 0) {
//			arr[start]++;
//		}
//		System.out.println("1" + Arrays.toString(arr));
//		int left = start;
//		int right = start;
//		while ((left > 0) && (right < T)) {
//			if (arr[left - 1] == 1 && arr[right + 1] == 1) {
//				arr[left - 1]--;
//				arr[right + 1]--;
//				left--;
//				right++;
//				System.out.println("2" + Arrays.toString(arr));
//				continue;
//			} else if (arr[left - 1] == 0 && arr[right + 1] == 0) {
//				arr[left - 1]++;
//				arr[right + 1]++;
//				left--;
//				right++;
//				System.out.println("3" + Arrays.toString(arr));
//				continue;
//			} else if ((arr[left - 1] == 0 && arr[right + 1] == 1)
//					|| (arr[left - 1] == 1 && arr[right + 1] == 0)) {
//				break;
//			}
//
//		}
//	}
		// 한 줄에 20개씩 출력
		for (int i = 0; i < T; i++) {
			System.out.print(arr[i] + " ");
			if ((i + 1) % 20 == 0)
				System.out.println();
		}
	}

}
