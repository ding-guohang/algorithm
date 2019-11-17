package com.dgh.algorithm.sort;

import static com.dgh.algorithm.sort.SortHelper.swap;

/**
 * 双路快排
 *
 * @author 丁国航 Meow on 2019-11-17
 */
public class QuickSort2 extends AbstractQuickSort {

    /**
     * input[left+1...i) 小于等于v
     * input(j...right] 大于等于v
     */
    @Override
    int partition(int[] input, int left, int right) {
        if (left >= right) {
            return left;
        }

        int v = input[left];
        int i = left + 1;
        int j = right;

        while (true) {
            while (i <= right && input[i] < v) {
                i++;
            }
            while (j >= left + 1 && input[j] > v) {
                j--;
            }

            if (i > j) {
                break;
            }

            swap(input, i, j);
            i++;
            j--;
        }

        swap(input, left, j);
        return j;
    }
}
