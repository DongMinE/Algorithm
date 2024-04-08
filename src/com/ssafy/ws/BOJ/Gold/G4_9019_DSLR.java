package com.ssafy.ws.BOJ.Gold;

import java.io.*;
import java.util.*;

public class G4_9019_DSLR {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        String[] oder = new String[]{"D", "S", "L", "R"};

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for (int i = 0; i < 4; i++) {

                if ()
                O(oder[i], a);
            }
        }


    }

    private static int O(String alpha, int current) {
        if (alpha.equals("D")) {
            current *= 2;
            if (current > 9999) {
                current %= 10000;
            }
            return current;
        } else if (alpha.equals("S")) {
            current -= 1;
            if (current == 0) {
                current = 9999;
            }
            return current;
        } else if (alpha.equals("L")) {
            current = (current % 1000) * 10 + current / 1000;
            return current;
        } else if (alpha.equals("R")) {
            current = (current % 10) * 1000 + (current / 10);
            return current;
        }

        return current;
    }
}
