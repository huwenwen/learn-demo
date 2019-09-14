package com.wen.leetcode;

/**
 * @author huwenwen
 * @since 27/09/2018
 */
public class No12 {

    /**
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int m = num / 1000;
        int bai;
        int shi;
        int ge;
        if (m > 0) {
            bai = num % 1000;
        } else {
            bai = num;
        }
        int t2 = bai / 100;
        if (t2 > 0) {
            shi = bai % 100;
        } else {
            shi = bai;
        }
        int t3 = shi / 10;
        if (t3 > 0) {
            ge = shi % 10;
        } else {
            ge = shi;
        }
        loop(sb, "M", m);
        join(sb, "M", "D", "C", t2);
        join(sb, "C", "L", "X", t3);
        join(sb, "X", "V", "I", ge);
        return sb.toString();
    }

    private void loop(StringBuilder sb, String c, int loop) {
        for (int i = 0; i < loop; i++) {
            sb.append(c);
        }
    }

    private void join(StringBuilder sb, String h, String m, String l, int mod) {
        if (mod <= 0) {
            return;
        }
        if (mod == 9) {
            sb.append(l).append(h);
        } else if (mod == 4) {
            sb.append(l).append(m);
        } else if (mod <= 3) {
            loop(sb, l, mod);
        } else if (mod >= 5) {
            sb.append(m);
            loop(sb, l, mod - 5);
        }
    }

    private String get(int num) {
        String[] flags = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int[] vals = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            if (num >= vals[index]) {
                sb.append(flags[index]);
                num -= vals[index];
            } else {
                index++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        //        System.out.println(new No12().intToRoman(3));
        //        System.out.println(new No12().intToRoman(4));
        //        System.out.println(new No12().intToRoman(9));
        //        System.out.println(new No12().intToRoman(58));
        System.out.println(new No12().intToRoman(1994));
        System.out.println(new No12().get(1994));
    }

}
