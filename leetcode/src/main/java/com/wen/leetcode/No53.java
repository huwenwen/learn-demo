package com.wen.leetcode;

/**
 * @author huwenwen
 * @since 2019/9/16
 */
public class No53 {

    /**
     * [-2,1,-3,4,-1,2,1,-5,4]
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(cur + nums[i], nums[i]);
            max = Math.max(max, cur);
        }
        return max;
    }

}
