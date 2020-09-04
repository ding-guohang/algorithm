package com.dgh.leetcode;

/**
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,6,5,1,8]
 * 输出：18
 * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 * 示例 2：
 * <p>
 * 输入：nums = [4]
 * 输出：0
 * 解释：4 不能被 3 整除，所以无法选出数字，返回 0。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,4,4]
 * 输出：12
 * 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/greatest-sum-divisible-by-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 丁国航 Meow on 2020/9/4
 */
public class Number1262 {

    /**
     * 1. 挑出所有能被3整除的数，这些数一定是组成部分
     * 2. 剩下的里面从大到小的挑选？
     * -- 算出总数，然后尽可能只减小最小的数据，来达到被3整除的效果 ?
     * -- 这个方法好使，不过要想得更细一点，
     * --- 如果总和 %3 == 1, 则找尽可能小的%3 == 1的数 或者 2个%3 == 2的数 剔除
     * --- 如果总和 %3 == 2, 则找尽可能小的%3 == 2的数 或者 2个%3 == 1的数 剔除
     * -----
     * 官方答案是dp，我试试
     * dp[i][0] = [0,i)这个区间 最大的%3==0的组合的和
     * dp[i][0] =
     * ----- nums[i-1]%3 == 0 -> dp[i-1][0] + nums[i-1]
     * ----- nums[i-1]%3 == 1 -> max(dp[i-1][0], dp[i-1][2]+nums[i-1])
     * ----- nums[i-1]%3 == 2 -> max(dp[i-1][0], dp[i-1][1]+nums[i-1])
     */
    public int maxSumDivThree(int[] nums) {
        int[][] dp = new int[nums.length + 1][3];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            switch (nums[i - 1] % 3) {
                case 0:
                    dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][0] + nums[i - 1]);
                    dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][1] + nums[i - 1]);
                    dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][2] + nums[i - 1]);
                    break;
                case 1:
                    dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] + nums[i - 1]);
                    dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + nums[i - 1]);
                    dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + nums[i - 1]);
                    break;
                case 2:
                    dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + nums[i - 1]);
                    dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] + nums[i - 1]);
                    dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0] + nums[i - 1]);
                    break;
            }
        }
        return dp[nums.length][0];
    }
}
