package com.dgh.algorithm.sort;

import static com.dgh.algorithm.sort.SortHelper.swap;

/**
 * 核心思路： 把自己插入到前面的有序组合的正确位置
 * 优化思路： 减少swap（忘记怎么实现了）
 *
 * @author 丁国航 Meow on 2019-10-29
 */
public class InsertionSort implements Sort {

    @Override
    public void sort(int[] input) {

        for (int i = 1; i < input.length; i++) {
            for (int j = i; j > 0; j--) {
                if (input[j - 1] <= input[j]) {
                    break;
                }

                swap(input, j - 1, j);
            }
        }
    }
}
