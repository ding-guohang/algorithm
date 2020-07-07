package com.dgh.leetcode;

/**
 * 给你一个整数数组 salary ，数组里每个数都是 唯一 的，其中 salary[i] 是第 i 个员工的工资。
 * <p>
 * 请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：salary = [4000,3000,1000,2000]
 * 输出：2500.00000
 * 解释：最低工资和最高工资分别是 1000 和 4000 。
 * 去掉最低工资和最高工资以后的平均工资是 (2000+3000)/2= 2500
 * <p>
 * 提示：
 * <p>
 * 3 <= salary.length <= 100
 * 10^3 <= salary[i] <= 10^6
 * salary[i] 是唯一的。
 * 与真实值误差在 10^-5 以内的结果都将视为正确答案
 *
 * @author 丁国航 Meow on 2020/7/7
 */
public class Number1491 {

    public double average(int[] salary) {
        if (null == salary || salary.length < 3) {
            return 0;
        }

        double max = salary[0];
        double min = salary[0];
        double total = 0;
        for (int value : salary) {
            total += value;
            if (max < value) {
                max = value;
            }
            if (min > value) {
                min = value;
            }
        }
        return (total - max - min) / (salary.length - 2);
    }
}
