package com.dgh.algorithm.sort;

import java.util.Arrays;

/**
 * @author 丁国航 Meow on 2019-10-29
 */
public final class SortHelper {

    public static void swap(int[] data, int indexA, int indexB) {
        if (indexA == indexB) {
            return;
        }

        if (indexA >= data.length || indexB >= data.length) {
            return;
        }

        if (indexA < 0 || indexB < 0) {
            return;
        }

        data[indexA] = data[indexA] ^ data[indexB];
        data[indexB] = data[indexA] ^ data[indexB];
        data[indexA] = data[indexA] ^ data[indexB];
    }

    public static void isSorted(int[] data) {
        for (int i = 1; i < data.length; i ++) {
            if (data[i - 1] > data[i]) {
                throw new RuntimeException("error sort, index = " + i);
            }
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        swap(data, 0, 8);
        swap(data, 1, 4);

        System.out.println(Arrays.toString(data));
    }
}
