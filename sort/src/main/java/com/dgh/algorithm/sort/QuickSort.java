package com.dgh.algorithm.sort;

import java.util.concurrent.ThreadLocalRandom;

import static com.dgh.algorithm.sort.SortHelper.swap;

/**
 * 快速排序
 * 排序思路：选择一个值，将数组变成比他小的在他左边，比他大的在他右边，然后再对每个partition分别进行快速排序
 * 优化思路：上面这个做法在遇到大量数值相同的情况下，容易导致两端partition的大小比较极端，退化为o(n2)的算法，因此可以修改为双路快速排序
 *
 * @author 丁国航 Meow on 2019-11-16
 */
public class QuickSort implements Sort {

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
    private int partition(int[] input, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int splitValue = input[left];

        // 对input，j和i的定义意味着 input[left...j]都小于splitValue，input[j+1...i)都大于splitValue
        // 所以起步数据j=left, i=left+1 就可以达到2个数组都是空的效果，完全符合定义
        int j = left;

        for (int i = left + 1; i <= right; i++) {
            if (input[i] < splitValue) {
                swap(input, i, ++j);
            }
        }

        swap(input, left, j);
        return j;
    }
}
