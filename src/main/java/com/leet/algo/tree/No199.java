package com.leet.algo.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jkliu
 * @description
 * @create 2022-02-20 4:22 PM
 **/
public class No199 {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        List<Integer> result = new ArrayList<>();

        while (!list.isEmpty()) {
            List<TreeNode> next = new ArrayList<>();
            Integer elem = null;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).left != null) {
                    next.add(list.get(i).left);
                }
                if (list.get(i).right != null) {
                    next.add(list.get(i).right);
                }
                elem = list.get(i).val;
            }
            result.add(elem);
            list = next;
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
