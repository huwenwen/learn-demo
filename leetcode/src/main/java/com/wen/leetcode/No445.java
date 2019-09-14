package com.wen.leetcode;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huwenwen
 * @since 28/09/2018
 */
public class No445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Map<String, ListNode> map = reverse2(l1, l2);
        l1 = map.get("h1");
        l2 = map.get("h2");
        int carry = 0;
        ListNode first = null;
        ListNode last = null;
        while (l1 != null || l2 != null) {
            int v1 = 0;
            int v2 = 0;
            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }
            int i = v1 + v2 + carry;
            ListNode temp;
            temp = last;
            ListNode newNode = new ListNode(i % 10);
            last = newNode;
            if (temp == null) {
                first = last;
            } else {
                temp.next = last;
            }
            carry = i / 10;
        }
        if (carry > 0) {
            last.next = new ListNode(carry);
        }
        return reverse2(first, null).get("h1");
    }

    private ListNode reverse(ListNode head) {
        ListNode p = head;
        ListNode q = head.next;
        head.next = null;
        ListNode temp;
        while (q != null) {
            temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }
        return p;
    }

    private Map<String, ListNode> reverse2(ListNode head1, ListNode head2) {
        ListNode q1 = null;
        if (head1 != null) {
            q1 = head1.next;
            head1.next = null;
        }
        ListNode q2 = null;
        if (head2 != null) {
            q2 = head2.next;
            head2.next = null;
        }
        ListNode r;
        while (q1 != null || q2 != null) {
            if (q1 != null) {
                r = q1.next;
                q1.next = head1;
                head1 = q1;
                q1 = r;
            }
            if (q2 != null) {
                r = q2.next;
                q2.next = head2;
                head2 = q2;
                q2 = r;
            }
        }
        Map<String, ListNode> map = new HashMap<>();
        map.put("h1", head1);
        map.put("h2", head2);
        return map;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(9);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        ListNode root2 = new ListNode(1);
        root2.next = new ListNode(2);
        root2.next.next = new ListNode(3);
        root2.next.next.next = new ListNode(4);
        root2.next.next.next.next = new ListNode(5);
//        new No445().addTwoNumbers(root, root2);
        new No445().addNumbers(root, root2);
    }

    public ListNode addNumbers(ListNode l1, ListNode l2) {
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                num1.append(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                num2.append(l2.val);
                l2 = l2.next;
            }
        }
        String total = new BigDecimal(num1.toString()).add(new BigDecimal(num2.toString())).setScale(0).toString();
        ListNode first = null;
        ListNode last = null;
        for (int i = 0; i < total.length(); i++) {
            ListNode newNode = new ListNode(Integer.valueOf(total.substring(i, i + 1)));
            if (first == null) {
                first = newNode;
            } else {
                last.next = newNode;
            }
            last = newNode;
        }
        return first;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
