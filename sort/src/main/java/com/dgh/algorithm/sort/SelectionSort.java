package com.dgh.algorithm.sort;

import static com.dgh.algorithm.sort.SortHelper.swap;

/**
 * 选择排序
 * 核心思路: 选择无序数组里面最小/最大的元素
 *
 * @author 丁国航 Meow on 2019-10-29
 */
public class SelectionSort implements Sort {

    public void sort(int[] input) {
        for (int i = 0; i < input.length; i++) {
            // find minimum
            int minIndex = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[minIndex]) {
                    minIndex = j;
                }
            }

            swap(input, i, minIndex);
        }
    }
}
