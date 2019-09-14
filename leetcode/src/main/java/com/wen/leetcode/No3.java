package com.wen.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author huwenwen
 * @since 26/09/2018
 */
public class No3 {

    /**
     * 循环遍历string, 放在set中,遇到重复的则把从头到这个重复的元素全部删除，继续
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new No3().lengthOfLongestSubstring("abcbdfe"));
        System.out.println(new No3().lengthOfLongestSubstring("abcdc"));
        System.out.println(new No3().lengthOfLongestSubstring("ababc"));
    }

}
