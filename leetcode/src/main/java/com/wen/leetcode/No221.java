package com.wen.leetcode;

/**
 * @author huwenwen
 * @since 2019/9/16
 */
public class No221 {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    int min = 0;
                    if (i > 0 && j > 0) {
                        min = Math.min(Math.min(matrix[i - 1][j - 1] - '0', matrix[i][j - 1] - '0'), matrix[i - 1][j] - '0');
                    }
                    int temp = (matrix[i][j] - '0') + min;
                    max = Math.max(max, temp);
                    max = max > 0 ? max : 1;
                    matrix[i][j] = (char) (temp + '0');
                }
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        //        char[][] matrix = { { '1', '1', '1' }, { '1', '1', '1' }, { '1', '1', '1' } };
        char[][] matrix = { { '1' } };
        new No221().maximalSquare(matrix);
    }
}
