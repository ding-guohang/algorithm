package com.dgh.leetcode;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *
 * @author 丁国航 Meow on 2020/9/27
 */
public class Number105_Tree_Build {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 我的思路比较简单，通过前序遍历找到根，然后通过中序遍历分为左右子树，再各自构建
     * 前序：{ 根节点, [左子树], [右子树] }
     * 中序：{ [左子树], 根节点, [右子树] }
     * 两种遍历方式的左子树和右子树长度一定是一致的，因为是相同的树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int pIndex, int[] inorder, int iLeft, int iRight) {
        if (iLeft > iRight) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pIndex]);
        int index = find(inorder, preorder[pIndex], iLeft, iRight);
        int length = index - iLeft;

        root.left = buildTree(preorder, pIndex + 1, inorder, iLeft, index - 1);
        root.right = buildTree(preorder, pIndex + 1 + length, inorder, index + 1, iRight);
        return root;
    }

    private int find(int[] input, int target, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (input[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
