package com.dgh.algorithm.sort;

import java.util.Arrays;

/**
 * @author 丁国航 Meow on 2019-11-16
 */
public class MergeSort implements Sort {


    @Override
    public void sort(int[] input) {

        mergeSort(input, 0, input.length - 1);
    }

    /**
     * 对input的[left...right]区间排序
     */
    private void mergeSort(int[] input, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (right - left) / 2 + left;
        mergeSort(input, left, mid);
        mergeSort(input, mid + 1, right);
        merge(input, left, mid, right);
    }

    /**
     * merge input的[left....mid] 和 (mid + 1...right]
     */
    private void merge(int[] input, int left, int mid, int right) {
        // 2个有序区间的边界值正好符合大小关系，说明已经整体有序了
        if (input[mid] <= input[mid + 1]) {
            return;
        }

        int[] data = Arrays.copyOf(input, right - left + 1);
        int i = left;
        int j = mid + 1;

        for (int k = left; k <= right; k++) {
            // 这个地方花了很多时间，因为始终没有意识到 i 和 j这个指针是input数组的，对应的值落到data中应该是 i - left 和 j - left
            if (j > right) {
                input[k] = data[i - left];
                i++;
                continue;
            }

            if (i > mid) {
                input[k] = data[j - left];
                j++;
                continue;
            }

            if (data[i - left] > data[j - left]) {
                input[k] = data[j - left];
                j++;
            } else {
                input[k] = data[i - left];
                i++;
            }

        }
    }
}

