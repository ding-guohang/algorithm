package com.dgh.leetcode;

/**
 * @author 丁国航 Meow on 2020/9/8
 */
public class Number1437_Simple {

    public boolean kLengthApart(int[] nums, int k) {
        int prev = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }

            if (prev < 0) {
                prev = i;
                continue;
            }

            if (i - prev - 1 < k) {
                return false;
            }

            prev = i;
        }
        return true;
    }
}
