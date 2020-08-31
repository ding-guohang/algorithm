package com.dgh.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 丁国航 Meow on 2020/8/28
 */
public class Number104 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     */
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int maxDepth = 1;
        Map<TreeNode, Integer> depths = new HashMap<>();
        depths.putIfAbsent(root, 1);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            int nextDepth = depths.get(node) + 1;
            if (null != node.left) {
                depths.putIfAbsent(node.left, nextDepth);
                stack.push(node.left);
                maxDepth = Math.max(maxDepth, nextDepth);
            }
            if (null != node.right) {
                depths.putIfAbsent(node.right, nextDepth);
                stack.push(node.right);
                maxDepth = Math.max(maxDepth, nextDepth);
            }
        }

        return maxDepth;
    }
}
