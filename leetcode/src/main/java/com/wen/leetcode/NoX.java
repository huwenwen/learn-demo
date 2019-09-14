package com.wen.leetcode;

/**
 * @author huwenwen
 * @since 2019/9/10
 */
public class NoX {

    /**
     * it is a book -> book a is it
     *
     * @param words
     * @return
     */
    public String reverseWords(String words) {
        StringBuilder sb = new StringBuilder();
        String[] split = words.split("\\s+");
        for (int i = split.length - 1; i >= 0; i--) {
            sb.append(split[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new NoX().reverseWords("  it is  a  book  "));
    }

}
