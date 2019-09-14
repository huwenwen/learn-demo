package com.wen.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huwenwen
 * @since 27/09/2018
 */
public class No700 {

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root != null) {
            if (root.val == val) {
                return root;
            }
            TreeNode left = searchBST(root.left, val);
            if (left != null) {
                return left;
            }
            TreeNode right = searchBST(root.right, val);
            if (right != null) {
                return right;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] array = { 4, 2, 7, 1, 3 };
        System.out.println(searchBST(stringToTreeNode(array), 2));

    }

    public static TreeNode stringToTreeNode(int[] parts) {
        int item = parts[0];
        TreeNode root = new No700().new TreeNode(item);
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            node.left = new No700().new TreeNode(item);
            nodeQueue.add(node.left);

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            node.right = new No700().new TreeNode(item);
            nodeQueue.add(node.right);
        }
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" + "val=" + val + ", left=" + left + ", right=" + right + '}';
        }
    }

}




