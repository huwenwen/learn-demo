package com.wen.leetcode;

import com.wen.leetcode.utils.TreeNode;

/**
 * @author huwenwen
 * @since 2019/9/14
 */
public class No236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return root;
        }
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
