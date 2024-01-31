package com.ssafy.ws.BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class S4_1620_나는야포켓몬마스터이다솜 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> map = new HashMap<>();
        HashMap<String, Integer> StringMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String val = br.readLine();
            map.put(i + 1, val);
            StringMap.put(val, i+1);
        }


        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            Pattern p = Pattern.compile("\\d+");
//            Matcher k = p.matcher(input);
            if (p.matcher(input).matches()) {
                System.out.println(map.get(Integer.parseInt(input)));
            } else {
                System.out.println(StringMap.get((input)));
            }
        }


//        for(int i = 0; i < m; i++) {
//            String input = br.readLine();
//            if(49 <= input.charAt(0) && input.charAt(0) <= 57) {
//                System.out.println(map.get(Integer.parseInt(input)));
//            }else {
//                System.out.println(StringMap.get((input)));
//            }
//        }

//        for (Integer val : map.keySet()) {
//            System.out.println("key: " + val + ", " + " val: " + map.get(val));
//        }
    }
}
