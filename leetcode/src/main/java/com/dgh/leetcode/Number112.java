package com.dgh.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
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
public class Number112 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 广度遍历，计算出到每一个节点的和
     * 每个节点的和是父节点+自己
     *
     * 优化方法就是实时校验，每计算出来一个值，就和sum比较一下，节省时间
     * 然后只需要保留上一个父节点，不需要map，可以节省空间
     *
     * 噢，上面这个方案稍微有点问题，是只能计算叶子节点
     * 不过优化方案没啥问题
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (null == root) {
            return false;
        }
        Set<Integer> sums = parseSum(root);
        return sums.contains(sum);
    }

    private Set<Integer> parseSum(TreeNode root) {
        Set<Integer> ret = new HashSet<>();
        Map<TreeNode, Integer> sums = new HashMap<>();
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
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

            if (null == node.right && null == node.left) {
                ret.add(sums.getOrDefault(node, node.val));
            }
        }
        return ret;
    }

}
