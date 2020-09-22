package com.dgh.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你 root1 和 root2 这两棵二叉搜索树。
 * <p>
 * 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root1 = [2,1,4], root2 = [1,0,3]
 * 输出：[0,1,1,2,3,4]
 * 示例 2：
 * <p>
 * 输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * 输出：[-10,0,0,1,2,5,7,10]
 * 示例 3：
 * <p>
 * 输入：root1 = [], root2 = [5,1,7,0,2]
 * 输出：[0,1,2,5,7]
 * 示例 4：
 * <p>
 * 输入：root1 = [0,-10,10], root2 = []
 * 输出：[-10,0,10]
 *
 * @author 丁国航 Meow on 2020/9/22
 */
public class Number1305_Tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 二叉搜索树：左 < 根 < 右
     */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> tree1 = parse(root1, new ArrayList<>());
        List<Integer> tree2 = parse(root2, new ArrayList<>());
        List<Integer> ret = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (true) {

            if (i >= tree1.size()) {
                for (int k = j; k < tree2.size(); k++) {
                    ret.add(tree2.get(k));
                }
                return ret;
            }

            if (j >= tree2.size()) {
                for (int k = i; k < tree1.size(); k++) {
                    ret.add(tree1.get(k));
                }
                return ret;
            }

            if (tree1.get(i) <= tree2.get(j)) {
                ret.add(tree1.get(i));
                i++;
                continue;
            }

            ret.add(tree2.get(j));
            j++;
        }
    }

    private List<Integer> parse(TreeNode root, List<Integer> ret) {
        if (null == root) {
            return ret;
        }

        if (null != root.left) {
            parse(root.left, ret);
        }

        ret.add(root.val);

        if (null != root.right) {
            parse(root.right, ret);
        }
        return ret;
    }
}
