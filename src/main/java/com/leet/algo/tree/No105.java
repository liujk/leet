package com.leet.algo.tree;

/**
 * @author jkliu
 * @description
 * @create 2022-03-08 3:38 PM
 **/
public class No105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int root = preorder[preStart];
        int inorderRootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (root == inorder[i]) {
                inorderRootIndex = i;
                break;
            }
        }
        int leftSize = inorderRootIndex - inStart;
        TreeNode rootNode = new TreeNode(root);
        rootNode.left = build(preorder, preStart + 1, preStart + leftSize,
                                  inorder, inStart, inorderRootIndex - 1);
        rootNode.right = build(preorder, preStart + leftSize + 1, preEnd,
                               inorder, inorderRootIndex + 1, inEnd);
        return rootNode;
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
