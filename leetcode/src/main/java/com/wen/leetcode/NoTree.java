package com.wen.leetcode;

import com.wen.leetcode.utils.TreeNode;

import java.util.*;

/**
 * @author huwenwen
 * @since 2019/9/14
 */
public class NoTree {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            List<Integer> subList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode e = queue.poll();
                if (flag) {
                    subList.add(e.val);
                } else {
                    subList.add(0, e.val);
                }
                if (e.left != null)
                    queue.offer(e.left);
                if (e.right != null)
                    queue.offer(e.left);
            }
            list.add(subList);
            flag = !flag;
        }
        return list;
    }
}
