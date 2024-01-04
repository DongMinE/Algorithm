package com.ssafy.ws.BOJ.Silver;

import java.io.*;
import java.util.*;

public class S5_1676_팩토리얼0의_개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int count = 0;

        while (num >= 5) {
            count += num / 5;
            num /= 5;
        }
        System.out.println(count);
    }

}
