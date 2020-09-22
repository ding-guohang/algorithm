package com.dgh.leetcode;

/**
 * @author 丁国航 Meow on 2020/9/22
 */
public class Number48_Simple {

    public void rotate(int[][] matrix) {
        rotate(matrix, 0, 0, matrix.length);
    }

    private void rotate(int[][] matrix, int left, int top, int length) {
        if (length <= 1) {
            return;
        }
        // 用第一行去触发旋转
        for (int i = left; i < left + length - 1; i++) {
            // 每个对应3个旋转, 4个点
            int[] first = new int[]{i, top};
            int[] second = new int[]{left + length - 1, top + i - left};
            int[] third = new int[]{left + length - 1 - (i - left), top + length - 1};
            int[] forth = new int[]{left, top + length - 1 - (i - left)};
//            System.out.println(i);
//            System.out.println(Arrays.toString(first));
//            System.out.println(Arrays.toString(second));
//            System.out.println(Arrays.toString(third));
//            System.out.println(Arrays.toString(forth));
//            System.out.println("*****");
            int firstData = matrix[first[1]][first[0]];
            int secondData = matrix[second[1]][second[0]];
            int thirdData = matrix[third[1]][third[0]];
            int forthData = matrix[forth[1]][forth[0]];
            matrix[first[1]][first[0]] = forthData;
            matrix[second[1]][second[0]] = firstData;
            matrix[third[1]][third[0]] = secondData;
            matrix[forth[1]][forth[0]] = thirdData;
        }

//        for (int[] m : matrix) {
//            System.out.println(Arrays.toString(m));
//        }

        rotate(matrix, left + 1, top + 1, length - 2);
    }

    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        new Number48_Simple().rotate(matrix);
    }

}
