package com.wen.leetcode;

import java.util.ArrayList;

/**
 * @author huwenwen
 * @since 2019/9/16
 */
public class No60 {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> num = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            num.add(i);
        }
        for (int i = 0, l = k - 1; i < n; i++) {
            fact /= (n - i);
            int index = (l / fact);
            sb.append(num.remove(index));
            l -= index * fact;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new No60().getPermutation(4, 7);
    }
}
