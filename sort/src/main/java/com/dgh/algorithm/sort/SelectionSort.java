package com.dgh.algorithm.sort;

/**
 * 选择排序
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

            SortHelper.swap(input, i, minIndex);
        }
    }
}
