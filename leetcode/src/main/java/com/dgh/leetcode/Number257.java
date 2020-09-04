package com.dgh.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 丁国航 Meow on 2020/9/4
 */
public class Number257 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        find(root, new ArrayList<>(), ret);
        return ret;
    }

    private void find(TreeNode node, List<Integer> ret, List<String> result) {
        if (null == node) {
            return;
        }
        ret.add(node.val);

        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            ret.forEach(r -> sb.append(r).append("->"));
            sb.delete(sb.length() - 2, sb.length());
            result.add(sb.toString());
            return;
        }

        find(node.left, new ArrayList<>(ret), result);
        find(node.right, new ArrayList<>(ret), result);
    }
}
