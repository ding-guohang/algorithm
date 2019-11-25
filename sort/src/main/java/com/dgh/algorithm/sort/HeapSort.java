package com.dgh.algorithm.sort;

import static com.dgh.algorithm.sort.SortHelper.swap;

/**
 * @author 丁国航 Meow on 2019-11-25
 */
public class HeapSort implements Sort {

    public static class MaxHeap {

        private int count;
        private int[] data;

        public MaxHeap(int capacity) {
            this.count = 0;
            this.data = new int[capacity + 1];
        }

        public MaxHeap(int[] input) {
            heapify(input);
        }

        private void heapify(int[] input) {

        }

        private void shiftUp(int k) {
            while (k > 1 && data[k] > data[k / 2]) {
                swap(data, k, k / 2);
                k = k / 2;
            }
        }

        private void shiftDown(int k) {
            while (k * 2 <= count) {
                int j = k * 2; // j就是会和k交换的值
                if (j + 1 <= count && data[j] < data[j + 1]) {
                    j = j + 1;
                }

                if (data[k] >= data[j]) {
                    break;
                }

                swap(data, k, j);
                k = j;
            }
        }


        public int pop() {
            if (count <= 0) {
                throw new RuntimeException("out of bound");
            }

            int max = data[1];
            swap(data, 1, count);
            count--;
            shiftDown(1);
            return max;
        }

        public void insert(int i) {
            if (count + 1 > data.length - 1) {
                throw new RuntimeException("out of bound");
            }

            count++;
            data[count] = i;
            shiftUp(count);
        }

    }


    @Override
    public void sort(int[] input) {
        MaxHeap heap = new MaxHeap(input.length);
        for (int i : input) {
            heap.insert(i);
        }

        for (int i = heap.count; i >= 1; i--) {
            input[i - 1] = heap.pop();
        }
    }
}
