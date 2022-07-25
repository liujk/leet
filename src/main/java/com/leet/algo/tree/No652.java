package com.leet.algo.tree;

import java.util.List;

/**
 * @author jkliu
 * @description
 * @create 2022-07-15 10:58 AM
 **/
public class No652 {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
return null;
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
