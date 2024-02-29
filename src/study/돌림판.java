package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 돌림판 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("뽑을 숫자의 범위를 입력해주세요: ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            System.out.print("진행할 인원을 입력하세요: ");
            int l = Integer.parseInt(br.readLine());

            System.out.print("질문 개수를 입력해주세요: ");
            int k = Integer.parseInt(br.readLine());

            if (m - n + 1 < k) {
                System.out.println("뽑을 숫자가 범위보다 클 수 없습니다. 다시 입력해주세요.");
                System.out.println();
                continue;
            }

            Random random = new Random();

            for (int cycle = 1; cycle <= k; cycle++) {
                List<Integer> numbers = new ArrayList<>();
                System.out.println();
                System.out.println("과연~~!!! 당신이 답 할 질문은?! (문제 " + cycle + ")");

                for (int i = 1; i <= l; i++) {
                    int num;
                    do {
                        num = n + random.nextInt(m - n + 1);
                    } while (numbers.contains(num));
                    numbers.add(num);
                    System.out.print("사람 " + i + ": " + num);
                    if (i != 5) {
                        br.readLine();
                    }
                }

                if (cycle != k) {
                    System.out.println("엔터 누르면 다음 문제...");
                    br.readLine();
                }
            }

            System.out.println("축하드립니다!!! 오늘의 스터디가 끝났습니다. (●ó⌓ò●)");
            break;
        }
    }
}
