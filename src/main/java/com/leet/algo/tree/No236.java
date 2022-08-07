package com.leet.algo.tree;


/**
 * @author jkliu
 * @description
 * @create 2021-12-23 5:16 PM
 **/
public class No236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }
        return find(root, p.val, q.val);
    }

    private TreeNode find(TreeNode node, int p, int q) {
        if (node == null) {
            return null;
        }
        if (node.val == p || node.val == q) {
            return node;
        }
        TreeNode left = find(node.left, p, q);
        TreeNode right = find(node.right, p, q);
        if (left != null && right != null) {
            return node;
        }
        return left != null ? left : right;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
