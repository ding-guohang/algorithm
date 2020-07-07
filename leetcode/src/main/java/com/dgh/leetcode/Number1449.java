package com.dgh.leetcode;

/**
 * 给你一个整数数组 cost 和一个整数 target 。请你返回满足如下规则可以得到的 最大 整数：
 * <p>
 * 给当前结果添加一个数位（i + 1）的成本为 cost[i] （cost 数组下标从 0 开始）。
 * 总成本必须恰好等于 target 。
 * 添加的数位中没有数字 0 。
 * 由于答案可能会很大，请你以字符串形式返回。
 * <p>
 * 如果按照上述要求无法得到任何整数，请你返回 "0" 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：cost = [4,3,2,5,6,7,2,5,5], target = 9
 * 输出："7772"
 * 解释：添加数位 '7' 的成本为 2 ，添加数位 '2' 的成本为 3 。所以 "7772" 的代价为 2*3+ 3*1 = 9 。 "997" 也是满足要求的数字，但 "7772" 是较大的数字。
 * 数字     成本
 * 1  ->   4
 * 2  ->   3
 * 3  ->   2
 * 4  ->   5
 * 5  ->   6
 * 6  ->   7
 * 7  ->   2
 * 8  ->   5
 * 9  ->   5
 * 示例 2：
 * <p>
 * 输入：cost = [7,6,5,5,5,6,8,7,8], target = 12
 * 输出："85"
 * 解释：添加数位 '8' 的成本是 7 ，添加数位 '5' 的成本是 5 。"85" 的成本为 7 + 5 = 12 。
 * 示例 3：
 * <p>
 * 输入：cost = [2,4,6,2,4,6,4,4,4], target = 5
 * 输出："0"
 * 解释：总成本是 target 的条件下，无法生成任何整数。
 * 示例 4：
 * <p>
 * 输入：cost = [6,10,15,40,40,40,40,40,40], target = 47
 * 输出："32211"
 *  
 * <p>
 * 提示：
 * <p>
 * cost.length == 9
 * 1 <= cost[i] <= 5000
 * 1 <= target <= 5000
 *
 * @author 丁国航 Meow on 2020/7/7
 */
public class Number1449 {

    /**
     * cost相当的就可以用大数替代小数
     * dp[i][j] = 取前i个数总和为j的最大数字组合
     * dp[i][j] = max( dp[i-1][j], dp[i-1][j-cost[i-1]]+i ) 但是这里第i个可以选n次
     * 所以，应该是  dp[i][j] = max(  dp[i-1][j], dp[i][j-cost[i-1]+i  )  这里dp[i]表示的是选择了第i个物品，dp[i-1]标识的是选择了第i-1个作品
     * 所以 dp[i][j-cost[i-1]+i 包含了 1~n 个 第i个物品的选择
     */
    public String largestNumber(int[] cost, int target) {
        String[][] dp = new String[cost.length + 1][target + 1];
        dp[0][0] = "0";
        for (int j = 1; j <= target; j++) { // 一个物品都不要，视为非法
            dp[0][j] = "#";
        }
        for (int i = 1; i <= cost.length; i++) {
            dp[i][0] = "0";
        }

        for (int i = 1; i <= cost.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j < cost[i - 1] || "#".equals(dp[i][j - cost[i - 1]])) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = max(dp[i - 1][j], add(dp[i][j - cost[i - 1]], i));
                }
            }
        }
        return "#".equals(dp[cost.length][target]) ? "0" : dp[cost.length][target];
    }

    private String max(String a, String b) {
        if (null == a || null == b) {
            return null == a ? b : a;
        }
        if (a.length() != b.length()) {
            return a.length() > b.length() ? a : b;
        }

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) > b.charAt(i)) {
                return a;
            }
            if (a.charAt(i) < b.charAt(i)) {
                return b;
            }
        }
        return a;
    }

    private String add(String a, int i) {
        if (null == a || "0".equals(a)) {
            return String.valueOf(i);
        }

        return i + a;
    }

    public static void main(String[] args) {
        int[] input = new int[]{7, 6, 5, 5, 5, 6, 8, 7, 8};
        System.out.println(new Number1449().largestNumber(input, 12));

    }
}
