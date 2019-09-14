package com.wen.leetcode;

import com.wen.leetcode.utils.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huwenwen
 * @since 29/09/2018
 */
public class No19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        Map<Integer, ListNode> map = new HashMap<>();
        int i = 0;
        while (head != null) {
            map.put(i++, head);
            head = head.next;
        }
        // remove first
        if (map.size() == n) {
            return map.get(1);
        } else {
            ListNode pre = map.get(map.size() - n - 1);
            pre.next = map.get(map.size() - n + 1);
        }
        return map.get(0);
    }

    public static void main(String[] args) {
        int[] arry = { 1, 2, 3, 4, 5 };
        new No19().removeNthFromEnd(ListNode.getFromArray(arry), 5);
    }
}
