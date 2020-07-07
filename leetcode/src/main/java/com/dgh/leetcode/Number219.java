package com.dgh.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * <p>
 * 话说为啥随机总是随机到easy。。。知道我只能做得出来easy么
 *
 * @author 丁国航 Meow on 2020/7/7
 */
public class Number219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (null == nums || nums.length == 0) {
            return false;
        }

        Map<Integer, List<Integer>> sames = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sames.putIfAbsent(nums[i], new ArrayList<>());
            sames.get(nums[i]).add(i);
        }

        for (List<Integer> value : sames.values()) {
            if (value.size() < 2) {
                continue;
            }

            value.sort(Comparator.comparingInt(a -> a));
            for (int i = 0; i < value.size() - 1; i++) {
                if (value.get(i + 1) - value.get(i) <= k) {
                    return true;
                }
            }
        }

        return false;
    }
}
