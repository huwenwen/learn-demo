package com.wen.leetcode;

import com.wen.leetcode.utils.ListNode;

/**
 * @author huwenwen
 * @since 29/09/2018
 */
public class No24 {
    public ListNode swapPairs(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode temp;
        ListNode first = null;
        ListNode last = null;
        while (p != null && p.next != null) {
            temp = p.next;
            p.next = p.next.next;
            temp.next = p;
            p = temp;
            if (first == null) {
                first = p;
            } else {
                last.next.next = p;
            }
            last = p;
            p = p.next.next;
        }
        return first;
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5 };
        ListNode node = new No24().swapPairs(ListNode.getFromArray(array));
        System.out.println(node);
    }
}
