package com.wen.leetcode;

/**
 * @author huwenwen
 * @since 26/09/2018
 */
public class No829 {

    public static int find(int N) {
        if(N == 3){
//            return 2;
        }
        int count = 1;
        for (int i = 2; i < N; i++) {
            if ((i * (i + 1)) / 2 > N) {
                break;
            }
            if (i % 2 == 1 && N % i == 0) {
                count++;
            }
            if (i % 2 == 0 && N % i == i / 2) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // 8
        System.out.println(find(3));
    }

}
