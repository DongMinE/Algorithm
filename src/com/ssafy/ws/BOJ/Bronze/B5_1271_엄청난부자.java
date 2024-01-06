package com.ssafy.ws.BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B5_1271_엄청난부자 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger M = new BigInteger(st.nextToken());
        BigInteger N = new BigInteger(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append(M.divide(N)).append("\n").append(M.remainder(N));
        System.out.println(sb);
    }
}
