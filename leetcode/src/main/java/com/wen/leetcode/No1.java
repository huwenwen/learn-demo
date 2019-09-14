package com.wen.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huwenwen
 * @since 26/09/2018
 */
public class No1 {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length - 1; j++) {
                if (target == nums[i] + nums[j + 1]) {
                    return new int[] { i, j + 1 };
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer expect = map.get(target - nums[i]);
            if (expect != null) {
                return new int[] { expect, i };
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 7, 11, 15 };
        System.out.println(new No1().twoSum(nums, 26));
    }

}
