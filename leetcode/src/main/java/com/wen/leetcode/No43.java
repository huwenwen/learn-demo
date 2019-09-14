package com.wen.leetcode;

/**
 * @author huwenwen
 * @since 2019/9/9
 */
public class No43 {
    public String multiply(String n, String m) {
        int[] array = new int[n.length() + m.length()];
        char[] upper = n.toCharArray();
        char[] lower = m.toCharArray();
        for (int i = lower.length - 1; i >= 0; i--) {
            for (int j = upper.length - 1; j >= 0; j--) {
                int temp = (lower[i] - '0') * (upper[j] - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = temp + array[p2];
                array[p1] = sum / 10;
                array[p2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : array) {
            if (sb.length() > 0 || i != 0)
                sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new No43().multiply("1", "9"));
    }
}
