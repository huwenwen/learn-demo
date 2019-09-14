package com.wen.leetcode.utils;

/**
 * @author huwenwen
 * @since 29/09/2018
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode getFromArray(int[] array) {
        ListNode first = null;
        ListNode last = null;
        for (int i = 0; i < array.length; i++) {
            ListNode node = new ListNode(array[i]);
            if (first == null) {
                first = node;
            } else {
                last.next = node;
            }
            last = node;
        }
        return first;
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5 };
        getFromArray(array);
    }
}
