package com.wen.leetcode;

/**
 * @author huwenwen
 * @since 26/09/2018
 */
public class No2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = null;
        ListNode last = null;

        int carry = 0;
        ListNode f = l1;
        ListNode s = l2;
        while (true) {
            int i = f.val + s.val + carry;
            int mod = i % 10;
            carry = i / 10;

            ListNode temp = last;
            ListNode newNode = new ListNode(mod);
            last = newNode;
            if (temp == null) {
                first = newNode;
            } else {
                temp.next = last;
            }
            boolean b1 = false;
            boolean b2 = false;
            if (f.next != null) {
                f = f.next;
            } else {
                f = new ListNode(0);
                b1 = true;
            }
            if (s.next != null) {
                s = s.next;
            } else {
                s = new ListNode(0);
                b2 = true;
            }
            if (b1 && b2 && carry == 0) {
                break;
            }
        }
        return first;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
