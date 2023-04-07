package com.ssafy.live.day29FenwickTreeTest;
import java.util.Arrays;

public class FenwickTreeTest {
    static int[] data = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    static int[] tree;

    static void update(int index, int value) {
        while(index < tree.length) {
        	tree[index] += value;
            index += (index & -index);
        }
    }
    
    static int sum(int index) {
        int result = 0;
        while (index > 0) {
            result += tree[index];
            index -= (index & -index);
        }
        return result;
    }

    static int getRange(int start, int end) {
        return sum(end) - sum(start-1);
    }

    public static void main(String[] args) {
    	tree = new int[data.length];

        for (int i = 1; i < data.length; i++) {
        	update(i, data[i]);
        }
        
        //  [0, 1, 3, 3, 10, 5, 11, 7, 36, 9, 19]  
        System.out.println(Arrays.toString(tree));
        // 12
        System.out.println(getRange(3, 5));

        update(4, 3);
        //  [0, 1, 3, 3, 13, 5, 11, 7, 39, 9, 19]
        System.out.println(Arrays.toString(tree));
        System.out.println(getRange(3, 5));

    }
}
