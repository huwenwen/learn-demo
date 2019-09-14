package com.wen.leetcode;

import com.wen.leetcode.utils.ListNode;

/**
 * @author huwenwen
 * @since 29/09/2018
 */
public class No21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode first = null;
        ListNode last = null;
        int cur = 0;
        while (l1 != null || l2 != null) {
            boolean l1Remove = false;
            if (l1 != null) {
                cur = l1.val;
                l1Remove = true;
            }
            if (l2 != null) {
                if (l1Remove && l2.val < cur) {
                    cur = l2.val;
                    l1Remove = false;
                }
                if (!l1Remove) {
                    cur = l2.val;
                }
            }
            ListNode node = new ListNode(cur);
            if (first == null) {
                first = node;
            } else {
                last.next = node;
            }
            last = node;
            if (l1Remove) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }
        }
        return first;
    }
}
