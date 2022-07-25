package com.leet.algo.tree;

import org.springframework.stereotype.Component;

/**
 * @author jkliu
 * @description
 * @create 2022-03-07 2:10 PM
 **/
@Component
public class No654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) {
            return null;
        }
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int index = low;
        int max = Integer.MIN_VALUE;
        for (int i = low; i <= high; i++) {
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = build(nums, low, index - 1);
        node.right = build(nums, index + 1, high);
        return node;
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
