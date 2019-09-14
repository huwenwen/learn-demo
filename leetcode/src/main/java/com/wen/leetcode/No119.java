package com.wen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huwenwen
 * @since 27/09/2018
 */
public class No119 {
    public List<Integer> getRow(int rowIndex) {
        int row = rowIndex + 1;
        List<Integer> list = new ArrayList<>();
        int[][] triangle = new int[row][];
        for (int i = 0; i < row; i++) {
            triangle[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                if (i == 0 || j == 0 || i == j) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j] + triangle[i - 1][j - 1];
                }
                if (i == row - 1) {
                    list.add(triangle[i][j]);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        new No119().getRow(33);
    }
}
