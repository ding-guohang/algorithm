package com.dgh.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * @author 丁国航 Meow on 2020/7/7
 */
public class Number112V2 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 112的优化解法，试试看, 只优化了时间，内存还怪费劲的，是保留上一层节点，不是保留上一个
     * 看来这个时间优化没有卵用
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (null == root) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);

        Map<TreeNode, Integer> sums = new HashMap<>();
        sums.put(root, root.val);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (null != node.left) {
                queue.add(node.left);
                sums.put(node.left, node.left.val + sums.getOrDefault(node, node.val));
            }
            if (null != node.right) {
                queue.add(node.right);
                sums.put(node.right, node.right.val + sums.getOrDefault(node, node.val));
            }

            if (null == node.right && null == node.left && sums.getOrDefault(node, node.val) == sum) {
                return true;
            }
        }
        return false;
    }


}
