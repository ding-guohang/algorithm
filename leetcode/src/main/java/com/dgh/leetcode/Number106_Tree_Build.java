package com.dgh.leetcode;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *
 * @author 丁国航 Meow on 2020/9/28
 */
public class Number106_Tree_Build {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 类似105
     * 中序：{ [左子树], 根节点, [右子树] }
     * 后序：{ [左子树], [右子树], 根 }
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int iLeft, int iRight, int pLeft, int pRight) {
        if (iLeft > iRight || pLeft > pRight) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[pRight]);
        int rootIndex = find(inorder, postorder[pRight], iLeft, iRight);

        root.left = build(inorder, postorder, iLeft, rootIndex - 1, pLeft, pLeft + rootIndex - iLeft - 1);
        root.right = build(inorder, postorder, rootIndex + 1, iRight, pLeft + rootIndex - iLeft, pRight - 1);
        return root;
    }

    private int find(int[] input, int target, int left, int right) {
        for (int i = right; i >= left; i--) {
            if (input[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
