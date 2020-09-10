package com.dgh.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * @author 丁国航 Meow on 2020/9/10
 */
public class Number40_DFS {

    /**
     * 应该是先排序，然后回溯
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();

        sort(candidates);
        int prev = -1;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }

            if (candidates[i] == prev) {
                continue;
            }

            prev = candidates[i];
            find(candidates, i, new ArrayList<>(), ret, target);
        }
        return ret;
    }

    private void find(int[] candidates, int start, List<Integer> way, List<List<Integer>> ret, int target) {
        way.add(candidates[start]);
        int total = sum(way);
        if (total == target) {
            ret.add(way);
            return;
        }

        if (total > target) {
            return;
        }

        int prev = -1;
        for (int i = start + 1; i < candidates.length; i++) {
            if (candidates[i] == prev) {
                continue;
            }

            prev = candidates[i];
            find(candidates, i, new ArrayList<>(way), ret, target);
        }
    }

    private int sum(List<Integer> way) {
        int ret = 0;
        for (Integer i : way) {
            ret += i;
        }
        return ret;
    }


    /**
     * 回顾一下快速排序。。
     */
    private void sort(int[] candidates) {
        quickSort(candidates, 0, candidates.length - 1);
    }

    private void quickSort(int[] candidates, int left, int right) {
        if (left >= right) {
            return;
        }

        int i = left;
        int splitValue = candidates[left];
        for (int j = left + 1; j <= right; j++) {
            if (splitValue > candidates[j]) {
                swap(candidates, ++i, j);
            }
        }
        swap(candidates, left, i);

        quickSort(candidates, left, i - 1);
        quickSort(candidates, i + 1, right);
    }

    private void swap(int[] input, int a, int b) {
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new Number40_DFS().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
