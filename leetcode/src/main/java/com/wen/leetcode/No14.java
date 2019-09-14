package com.wen.leetcode;

/**
 * 最长公共前缀
 *
 * @author huwenwen
 * @since 2019/9/9
 */
public class No14 {

    public String maxLengthCommonPrefix(String[] strs) {
        StringBuilder commonPrefix = new StringBuilder();
        int i = 0;
        while (true) {
            Character common = null;
            for (String str : strs) {
                if (str.length() < i) {
                    return commonPrefix.toString();
                }
                if (common == null) {
                    common = str.charAt(i);
                } else {
                    if (!common.equals(str.charAt(i))) {
                        return commonPrefix.toString();
                    }
                }
            }
            commonPrefix.append(common);
            i++;
        }
    }

    public static void main(String[] args) {
        int[] count = new int[128];
        count[1]++;
        count[2]++;
        System.out.println(new No14().maxLengthCommonPrefix(new String[] {"ower", "flow", "flight"}));
    }

}
