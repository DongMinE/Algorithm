package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 돌림판 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            System.out.print("뽑을 숫자의 범위를 입력해주세요: ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            System.out.print("뽑을 개수를 입력해주세요: ");
            int k = Integer.parseInt(br.readLine());

            if (m - n + 1 < k) {
                System.out.println("뽑을 숫자가 범위보다 클 수 없습니다. 다시 입력해주세요.");
                System.out.println();
                continue;
            }

            Random random = new Random();
            Set<Integer> set = new TreeSet<>();
            System.out.println();
            System.out.println("과연~~!!! 당신이 답 할 질문은?!");

            for (int i = 0; i < k; i++) {
                int num;
                do {
                    num = n + random.nextInt(m - n + 1);
                } while (set.contains(num));
                set.add(num);
            }

            for (int num : set) {
                sb.append(num).append(" ");
            }
            System.out.println(sb);
            System.out.println("축하드립니다!!! (●ó⌓ò●)");
            break;
        }
    }
}
