package com.wen.leetcode;

/**
 * @author huwenwen
 * @since 28/09/2018
 */
public class No704 {

    public int search(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                // left
                right = mid - 1;
            } else {
                // right
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 0, 3, 5, 9, 12,13,14,16,18,20,40,50,245,255,567 };
        System.out.println(new No704().search(nums, 255));
    }

}
