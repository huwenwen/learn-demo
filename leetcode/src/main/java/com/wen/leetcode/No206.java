package com.wen.leetcode;

import com.wen.leetcode.utils.ListNode;

import java.util.Stack;

/**
 * @author huwenwen
 * @since 2019/9/13
 */
public class No206 {
    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }

    private ListNode reverse(ListNode h, ListNode newH) {
        if (h == null) {
            return newH;
        }
        ListNode next = h.next;
        h.next = newH;
        return reverse(next, h);
    }

    public ListNode reverseListV2(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    /**
     * 利用栈,循环了两次
     *
     * @param head
     * @return
     */
    public ListNode reverseListV2ByStack(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<Integer> stack = new Stack();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        ListNode newNode = new ListNode(stack.pop());
        while (!stack.isEmpty()) {
            newNode.next = new ListNode(stack.pop());
        }
        return newNode;
    }
}
