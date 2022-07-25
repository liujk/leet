package com.leet.algo.tree;

import org.springframework.stereotype.Component;

/**
 * @author jkliu
 * @description
 * @create 2022-07-15 9:43 AM
 **/
@Component
public class No297 {
    String SEP = ",";
    String NULL = "#";

    /* 主函数，将二叉树序列化为字符串 */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    /* 辅助函数，将二叉树存入 StringBuilder */
    void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        /****** 前序遍历位置 ******/
        sb.append(root.val).append(SEP);
        /***********************/

        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    int index = 0;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(SEP);
        return deserialize(nodes);
    }

    private TreeNode deserialize(String[] nodes) {
        if (index >= nodes.length) {
            return null;
        }
        if (nodes[index].equals(NULL)) {
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(nodes[index++]));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
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
