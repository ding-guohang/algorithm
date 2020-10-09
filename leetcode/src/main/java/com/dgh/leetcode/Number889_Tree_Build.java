package com.dgh.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 返回与给定的前序和后序遍历匹配的任何二叉树。
 * <p>
 *  pre 和 post 遍历中的值是不同的正整数。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * 输出：[1,2,3,4,5,6,7]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= pre.length == post.length <= 30
 * pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列
 * 每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。
 *
 * @author 丁国航 Meow on 2020/9/28
 */
public class Number889_Tree_Build {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 前序：{ root, [left], [right] }
     * 后序：{ [left], [right], root }
     */
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return build(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    public TreeNode build(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {
        if (preStart > preEnd || postStart > postEnd) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preStart]);
        int sameLength = sameArray(pre, preStart + 1, preEnd, post, postStart, postEnd - 1);
        root.left = build(pre, preStart + 1, preStart + 1 + sameLength, post, postStart, postStart + sameLength);
        root.right = build(pre, preStart + sameLength + 2, preEnd, post, postStart + sameLength + 1, postEnd - 1);
        return root;
    }

    public int sameArray(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {
        Set<Integer> preSet = new HashSet<>();
        Set<Integer> postSet = new HashSet<>();

        for (int i = 0; i <= preEnd - preStart; i++) {
            preSet.add(pre[i + preStart]);
            postSet.add(post[i + postStart]);

            if (preSet.equals(postSet)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] post = new int[]{4, 5, 2, 6, 7, 3, 1};

        System.out.println(new Number889_Tree_Build().sameArray(pre, 1, pre.length - 1, post, 0, post.length - 1));
    }
}
