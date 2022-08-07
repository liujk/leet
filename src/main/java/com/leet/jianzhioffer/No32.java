package com.leet.jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author jkliu
 * @description
 * @create 2022-07-30 4:31 PM
 **/
public class No32 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        int level = 1;
        while (nodes.size() > 0) {
            List<Integer> list = new ArrayList<>();
            List<TreeNode> curNodes = new ArrayList<>();
            Iterator<TreeNode> iterator = nodes.iterator();
            while (iterator.hasNext()) {
                TreeNode next = iterator.next();
                if (next != null) {
                    if (level % 2 == 0) {
                        list.add(0, next.val);
                    } else {
                        list.add(next.val);
                    }
                    if (next.left != null) {
                        curNodes.add(next.left);
                    }
                    if (next.right != null) {
                        curNodes.add(next.right);
                    }
                }
            }
            res.add(list);
            nodes = curNodes;
            level++;
        }
        return res;
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
