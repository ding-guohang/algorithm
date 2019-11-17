package com.dgh.algorithm.sort;

import com.google.common.base.Stopwatch;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static com.dgh.algorithm.sort.SortHelper.isSorted;

/**
 * @author 丁国航 Meow on 2019-10-29
 */
public class SortRunner {

    private static void run(Sort sorter) {
        int count = 10000;
        int[] input = new int[count];
        for (int i = 0; i < count; i++) {
            input[i] = ThreadLocalRandom.current().nextInt(count);
        }

        Stopwatch watch = Stopwatch.createStarted();
        sorter.sort(input);
        watch.stop();
        isSorted(input);
        System.out.println(String.format("Sorter: %s. Cost: %s", sorter.getClass().getSimpleName(),
                watch.elapsed(TimeUnit.MILLISECONDS)));
    }

    public static void main(String[] args) {
        run(new InsertionSort());
        run(new SelectionSort());
        run(new MergeSort());
        run(new QuickSort());
    }
}
