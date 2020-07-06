package com.dgh.leetcode;

import java.util.Arrays;

/**
 * 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
 * <p>
 * 请你返回能让所有学生以 非递减 高度排列的最小必要移动人数。
 * <p>
 * 注意，当一组学生被选中时，他们之间可以以任何可能的方式重新排序，而未被选中的学生应该保持不动。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：heights = [1,1,4,2,1,3]
 * 输出：3
 * 解释：
 * 当前数组：[1,1,4,2,1,3]
 * 目标数组：[1,1,1,2,3,4]
 * 在下标 2 处（从 0 开始计数）出现 4 vs 1 ，所以我们必须移动这名学生。
 * 在下标 4 处（从 0 开始计数）出现 1 vs 3 ，所以我们必须移动这名学生。
 * 在下标 5 处（从 0 开始计数）出现 3 vs 4 ，所以我们必须移动这名学生。
 * 示例 2：
 * <p>
 * 输入：heights = [5,1,2,3,4]
 * 输出：5
 * 示例 3：
 * <p>
 * 输入：heights = [1,2,3,4,5]
 * 输出：0
 * <p>
 * 高度检查器。。。我看题目觉得就是要排序而已，升序
 * 那就写一下快速排序吧
 * 排序结束之后，对比一下位置上的差异
 *
 * @author 丁国航 Meow on 2020/7/6
 */
public class Number1051 {

    public int heightChecker(int[] heights) {
        int[] input = new int[heights.length];
        System.arraycopy(heights, 0, input, 0, heights.length);

        sort(heights, 0, heights.length - 1);

        int ret = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != input[i]) {
                ret++;
            }
        }
        return ret;
    }

    public void sort(int[] heights, int left, int right) {
        if (left >= right) {
            return;
        }

        int splitValue = heights[left];
        int j = left;

        for (int i = left + 1; i <= right; i++) {
            if (heights[i] < splitValue) {
                swap(heights, i, ++j);
            }
        }

        swap(heights, left, j);

        sort(heights, left, j - 1);
        sort(heights, j + 1, right);
    }

    private void swap(int[] heights, int a, int b) {
        int temp = heights[a];
        heights[a] = heights[b];
        heights[b] = temp;
    }

    public static void main(String[] args) {
        int[] input = new int[]{7, 4, 5, 6, 4, 2, 1, 4, 6, 5, 4, 8, 3, 1, 8, 2, 7, 6, 3, 2};
        new Number1051().sort(input, 0, input.length - 1);

        System.out.println(Arrays.toString(input));
    }

}
