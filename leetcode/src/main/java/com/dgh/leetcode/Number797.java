package com.dgh.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给一个有 n 个结点的有向无环图，找到所有从 0 到 n-1 的路径并输出（不要求按顺序）
 * <p>
 * 二维数组的第 i 个数组中的单元都表示有向图中 i 号结点所能到达的下一些结点（译者注：有向图是有方向的，即规定了a→b你就不能从b→a）空就是没有下一个结点了。
 * <p>
 * 示例:
 * 输入: [[1,2], [3], [3], []]
 * 输出: [[0,1,3],[0,2,3]]
 * 解释: 图是这样的:
 * 0--->1
 * |    |
 * v    v
 * 2--->3
 * 这有两条路: 0 -> 1 -> 3 和 0 -> 2 -> 3.
 * 提示:
 * <p>
 * 结点的数量会在范围 [2, 15] 内。
 * 你可以把路径以任意顺序输出，但在路径内的结点的顺序必须保证。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-paths-from-source-to-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 丁国航 Meow on 2020/9/7
 */
public class Number797 {

    /**
     * 感觉像是一道回溯法的题目
     * 题目说了是有向无环，所以就穷举，到走不下去的时候看下自己访问的记录是不是全的
     * 误会了， 只是穷举而已，不需要回溯
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ret = new ArrayList<>();

        List<Integer> way = new ArrayList<>();
        find(graph, 0, way, ret);
        return ret;
    }

    private void find(int[][] graph, int now, List<Integer> way, List<List<Integer>> ret) {
        way.add(now);
        if (now == graph.length - 1) {
            ret.add(way);
            return;
        }

        int[] choices = graph[now];
        if (choices.length == 0) { //到终点了
            if (now == graph.length - 1) {
                ret.add(way);
            }
            return;
        }

        for (int choice : choices) {
            find(graph, choice, new ArrayList<>(way), ret);
        }
    }
}
