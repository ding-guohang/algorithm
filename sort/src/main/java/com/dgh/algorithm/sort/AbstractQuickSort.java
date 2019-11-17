package com.dgh.algorithm.sort;

import java.util.concurrent.ThreadLocalRandom;

import static com.dgh.algorithm.sort.SortHelper.swap;

/**
 * 快速排序
 *
 * @author 丁国航 Meow on 2019-11-17
 */
public abstract class AbstractQuickSort implements Sort {

    @Override
    public void sort(int[] input) {
        quickSort(input, 0, input.length - 1);
    }

    private void quickSort(int[] input, int left, int right) {
        if (left >= right) {
            return;
        }

        // 取一个随机数作为分界值，并放在数组的首位（不直接使用数组首位是担心遇到近乎有序的数组，而退化为O(n2)）
        int cursor = ThreadLocalRandom.current().nextInt(left, right);
        swap(input, left, cursor);

        int splitCursor = partition(input, left, right);
        quickSort(input, left, splitCursor - 1);
        quickSort(input, splitCursor + 1, right);
    }

    /**
     * 分界值是input[0]，目标是把所有比分界值小的放在他左侧，大于等于的放在右侧
     * 扫描返回是[left...right]
     * 最后返回分界值所在的位置
     */
    abstract int partition(int[] input, int left, int right);
}
