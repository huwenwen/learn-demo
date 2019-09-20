package com.wen.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huwenwen
 * @since 2019/9/16
 */
public class No120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty() || triangle.get(0).isEmpty()) {
            return 0;
        }
        int min = triangle.get(0).get(0);
        int minIndex = 0;
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> t = triangle.get(i);
            if(t.get(minIndex) > t.get(minIndex + 1)){
                min += t.get(minIndex + 1);
                minIndex = minIndex + 1;
            } else {
                min += t.get(minIndex);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));
        new No120().minimumTotal(triangle);
    }
}
