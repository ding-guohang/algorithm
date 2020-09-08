package com.dgh.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 丁国航 Meow on 2020/9/8
 */
public class Number77_DFS {

    /**
     * 穷举？
     */
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 1; i <= n - k + 1; i++) {
            append(n, k, i, new ArrayList<>(), ret);
        }
        return ret;
    }

    private void append(int n, int k, int start, List<Integer> way, List<List<Integer>> ret) {
        way.add(start);
        if (way.size() == k) {
            ret.add(new ArrayList<>(way));
            way.remove(way.size() - 1);
            return;
        }

        for (int i = start + 1; i <= n; i++) {
            append(n, k, i, way, ret);
        }
        way.remove(way.size() - 1);
    }
}
