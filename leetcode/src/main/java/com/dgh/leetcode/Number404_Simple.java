package com.dgh.leetcode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 丁国航 Meow on 2020/9/19
 */
public class Number404_Simple {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        AtomicInteger cnt = new AtomicInteger(0);
        cal(root, cnt, false);
        return cnt.get();
    }

    private void cal(TreeNode node, AtomicInteger cnt, boolean isLeft) {
        if (null == node) {
            return;
        }

        if (isLeft && null == node.left && null == node.right) {
            cnt.addAndGet(node.val);
            return;
        }

        if (null != node.left) {
            cal(node.left, cnt, true);
        }

        cal(node.right, cnt, false);
    }
}
