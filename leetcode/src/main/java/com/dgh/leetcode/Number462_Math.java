package com.dgh.leetcode;

import java.util.Arrays;

/**
 * 给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，其中每次移动可将选定的一个元素加1或减1。 您可以假设数组的长度最多为10000。
 * <p>
 * 例如:
 * <p>
 * 输入:
 * [1,2,3]
 * <p>
 * 输出:
 * 2
 * <p>
 * 说明：
 * 只有两个动作是必要的（记得每一步仅可使其中一个元素加1或减1）：
 * <p>
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 丁国航 Meow on 2020/9/14
 */
public class Number462_Math {

    /**
     * 找到要相等的值, 如果不重复的话，就是中间大小的值
     * 如果重复, 是不是也是数组中间那个？ —— 是，中位数
     */
    public int minMoves2(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        int ret = 0;
        for (int i : nums) {
            ret += Math.abs(mid - i);
        }
        return ret;
    }

}
