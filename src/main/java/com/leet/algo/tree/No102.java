package com.leet.algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jkliu
 * @description
 * @create 2021-11-24 2:01 PM
 **/
public class No102 {
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> first = new LinkedList<>();
        Queue<TreeNode> second = new LinkedList<>();

        first.offer(root);
        while (true) {
            List<Integer> rows = new ArrayList<>();
            while (!first.isEmpty()) {
                TreeNode poll = first.poll();
                rows.add(poll.val);
                if (poll.left != null) {
                    second.offer(poll.left);
                }
                if (poll.right != null) {
                    second.offer(poll.right);
                }
            }
            result.add(rows);
            if (second.isEmpty()) {
                break;
            }
            first = second;
            second = new LinkedList<>();
        }
        return result;
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
