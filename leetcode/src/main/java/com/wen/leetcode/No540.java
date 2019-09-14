package com.wen.leetcode;

import com.sun.tools.javac.util.Assert;

/**
 * @author huwenwen
 * @since 26/09/2018
 */
public class No540 {
    // TODO: 26/09/2018 二分法

    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length < 3) {
            throw new IllegalArgumentException("args illegal");
        }
        int right = nums.length - 1;
        int left = 0;
        while (right >= left) {
            int mid = (right + left) / 2;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            if (nums[mid] != nums[mid - 1]) {
                if (left == mid - 1) {
                    return nums[mid - 1];
                }
                if (mid % 2 == 0) {
                    if (left == mid - 1) {
                        return nums[mid - 1];
                    }
                    left = mid + 1;
                } else {
                    if (right == mid + 1) {
                        return nums[mid + 1];
                    }
                    right = mid - 1;
                }
            } else if (nums[mid] != nums[mid + 1]) {

                if (mid % 2 == 0) {
                    if (right == mid + 1) {
                        return nums[mid + 1];
                    }
                    right = mid - 1;
                } else {
                    if (left == mid - 1) {
                        return nums[mid - 1];
                    }
                    left = mid + 1;
                }
            }
        }
        throw new IllegalArgumentException("args illegal");
    }

    public int find(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (right >= left) {
            int mid = (right + left) / 2;
            if (mid % 2 == 0) {
                mid++;
            }
            if (nums[mid] == nums[mid - 1]) {
                left = mid + 1;
            } else if (nums[mid] == nums[mid + 1]) {
                right = mid - 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        //        int[] nums = { 1, 1, 2, 3, 3, 4, 4, 8, 8 }; // 4
        //                int[] nums = { 3, 3, 7, 7, 10, 11, 11 }; // 3
        //                int[] nums = { 3, 3, 7, 10, 10, 11, 11 }; // 3
        //        int[] nums = { 1, 1, 2, 2, 4, 4, 5, 5, 9 };
        //                int[] nums = { 3, 3, 7 };
        //                int[] nums = { 3, 7, 7 }; 1,2,3,3
        No540 no = new No540();
        Assert.check(no.find(new int[] { 1, 1, 2, 3, 3, 4, 4, 8, 8 }) == 2);
        Assert.check(no.find(new int[] { 3, 3, 7, 7, 10, 11, 11 }) == 10);
        Assert.check(no.find(new int[] { 3, 3, 7, 10, 10, 11, 11 }) == 7);
        Assert.check(no.find(new int[] { 1, 1, 2, 2, 4, 4, 5, 5, 9 }) == 9);
        Assert.check(no.find(new int[] { 3, 7, 7 }) == 3);
        Assert.check(no.find(new int[] { 3, 3, 7 }) == 7);
        Assert.check(no.find(new int[] { 3, 3, 7, 7, 9 }) == 9);
        Assert.check(no.find(new int[] { 3, 7, 7, 9, 9 }) == 3);

    }

}
