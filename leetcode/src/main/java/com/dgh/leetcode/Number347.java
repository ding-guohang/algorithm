package com.dgh.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 * <p>
 * 提示：
 * <p>
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 丁国航 Meow on 2020/9/7
 */
public class Number347 {

    public static class Count {
        int count = 0;
        int num = 0;

        public Count(int num) {
            this.num = num;
        }

        public void incr() {
            this.count++;
        }
    }

    /**
     * 遍历一遍计数
     * 计数完了用顶堆
     * 我为了方便直接排序了, 回头有机会可以考虑写一个堆。。。
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Count> counts = new HashMap<>();
        for (int num : nums) {
            counts.putIfAbsent(num, new Count(num));
            counts.get(num).incr();
        }

        ArrayList<Count> list = new ArrayList<>(counts.values());
        list.sort(Comparator.comparingInt(c -> c.count));
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = list.get(list.size() - 1 - i).num;
        }
        return ret;
    }
}
