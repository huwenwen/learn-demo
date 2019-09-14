package com.wen.leetcode.algorithm;

import java.util.LinkedList;

/**
 * @author huwenwen
 * @since 27/09/2018
 */
public class BinaryTree {

    /**
     * 前序遍历 root -> left -> right
     *
     * @param node
     */
    public void pre(TreeNode node) {
        if (node != null) {
            System.out.println(node.val);
            pre(node.left);
            pre(node.right);
        }
    }

    public void pre2(TreeNode node) {
        LinkedList<TreeNode> stack = new LinkedList();
        TreeNode pNode = node;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                System.out.println(pNode.val);
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                TreeNode pop = stack.pop();
                pNode = pop.right;
            }
        }
    }

    /**
     * 中序遍历 left -> root > right
     *
     * @param node
     */
    public void mid(TreeNode node) {
        if (node != null) {
            mid(node.left);
            System.out.println(node.val);
            mid(node.right);
        }
    }

    public void mid2(TreeNode node) {
        LinkedList<TreeNode> stack = new LinkedList();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode pop = stack.pop();
                System.out.println(pop.val);
                node = node.right;
            }
        }
    }

    /**
     * 后序遍历 left -> right -> root
     *
     * @param node
     */
    public void post(TreeNode node) {
        if (node != null) {
            post(node.left);
            post(node.right);
            System.out.println(node.val);
        }
    }

    /**
     * 层次遍历
     * 利用队列来实现
     *
     * @param node
     */
    public void level(TreeNode node) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode pop = queue.pop();
            System.out.println(pop.val);
            if (pop.left != null) {
                queue.offer(pop.left);
            }
            if (pop.right != null) {
                queue.offer(pop.right);
            }
        }
    }

    /**
     * 深度优先遍历
     * 利用栈实现
     *
     * @param node
     */
    public void depth(TreeNode node) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.println(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    public static TreeNode getTreeNode(int val) {
        return new BinaryTree().new TreeNode(val);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
