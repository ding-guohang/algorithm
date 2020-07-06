package com.dgh.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 * <p>
 * 广度遍历，所以i的父节点是(i-1)/2
 * 所以一直这么求，直到i == 1 or 2
 * 上面这个方式有点问题，很费劲，因为这个不是平衡的二叉树，其实可以直接记录每个子节点的父的
 *
 * @author 丁国航 Meow on 2020/7/6
 */
public class Number236 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parents = parse(root);

        while (p != null) {
            TreeNode r = q;
            while (r != null) {
                if (p == r) {
                    return p;
                }
                r = parents.get(r);
            }
            p = parents.get(p);
        }

        return null;
    }

    private Map<TreeNode, TreeNode> parse(TreeNode root) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (null != node.left) {
                queue.add(node.left);
                parents.put(node.left, node);
            }
            if (null != node.right) {
                queue.add(node.right);
                parents.put(node.right, node);
            }
        }
        return parents;
    }


}
