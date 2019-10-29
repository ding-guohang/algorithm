package com.dgh.algorithm.sort;

import com.google.common.base.Stopwatch;

import java.util.Arrays;
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
            input[i] = ThreadLocalRandom.current().nextInt(100);
        }

        Stopwatch watch = Stopwatch.createStarted();
        sorter.sort(input);
        watch.stop();

        isSorted(input);
        System.out.println(Arrays.toString(input));
        System.out.println(watch.elapsed(TimeUnit.MILLISECONDS));
    }

    public static void main(String[] args) {
        run(new InsertionSort());
    }
}
