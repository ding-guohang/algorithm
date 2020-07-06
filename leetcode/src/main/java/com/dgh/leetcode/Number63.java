package com.dgh.leetcode;

/**
 * 63题，中等难度，从左上到又下有多少种路径，1是障碍物（只能向右或者向下移动)
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * <p>
 * <p>
 * 我觉得应该是回溯法。。。
 * 一不小心看到了一眼官方题解，看到了动态规划几个字。。。那我试试
 *
 * @author 丁国航 Meow on 2020/7/6
 */
public class Number63 {

    /**
     * dp[i][j] = 到达[i,j]这个位置有几种方法
     * 如果存在且不等于0 -> dp[i-1][j] + dp[i][j-1]
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }

                if (i == 0 && j == 0) {
                    continue;
                }

                dp[i][j] = dp[Math.max(i - 1, 0)][j] + dp[i][Math.max(j - 1, 0)];
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}

