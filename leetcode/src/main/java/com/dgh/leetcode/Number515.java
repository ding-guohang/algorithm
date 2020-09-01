package com.dgh.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 您需要在二叉树的每一行中找到最大的值。
 * <p>
 * 示例：
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 3   2
 * / \   \
 * 5   3   9
 * <p>
 * 输出: [1, 3, 9]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 丁国航 Meow on 2020/9/1
 */
public class Number515 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Definition for a binary tree node.
     * 广度优先遍历，然后一次遍历一行吧
     */
    public List<Integer> largestValues(TreeNode root) {
        if (null == root) {
            return new ArrayList<>();
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> ret = new ArrayList<>();

        while (!stack.empty()) {
            Integer max = null;
            List<TreeNode> row = new ArrayList<>();
            while (!stack.empty()) {
                TreeNode node = stack.pop();
                if (null == max) {
                    max = node.val;
                } else {
                    max = Math.max(node.val, max);
                }
                if (null != node.left) {
                    row.add(node.left);
                }
                if (null != node.right) {
                    row.add(node.right);
                }
            }
            row.forEach(stack::push);
            ret.add(max);
        }
        return ret;
    }
}
