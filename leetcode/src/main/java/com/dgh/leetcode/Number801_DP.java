package com.dgh.leetcode;

/**
 * 我们有两个长度相等且不为空的整型数组 A 和 B 。
 * <p>
 * 我们可以交换 A[i] 和 B[i] 的元素。注意这两个元素在各自的序列中应该处于相同的位置。
 * <p>
 * 在交换过一些元素之后，数组 A 和 B 都应该是严格递增的（数组严格递增的条件仅为A[0] < A[1] < A[2] < ... < A[A.length - 1]）。
 * <p>
 * 给定数组 A 和 B ，请返回使得两个数组均保持严格递增状态的最小交换次数。假设给定的输入总是有效的。
 * <p>
 * 示例:
 * 输入: A = [1,3,5,4], B = [1,2,3,7]
 * 输出: 1
 * 解释:
 * 交换 A[3] 和 B[3] 后，两个数组如下:
 * A = [1, 3, 5, 7] ， B = [1, 2, 3, 4]
 * 两个数组均为严格递增的。
 * 注意:
 * <p>
 * A, B 两个数组的长度总是相等的，且长度的范围为 [1, 1000]。
 * A[i], B[i] 均为 [0, 2000]区间内的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-swaps-to-make-sequences-increasing
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 丁国航 Meow on 2020/9/8
 */
public class Number801_DP {

    /**
     * 我看代码，觉得是DP
     * dp[i][0] 表示 [0,i] 为严格递增且A[i]和B[i]不交换的最小交换次数
     * dp[i][1] 表示 [0,i] 为严格递增且A[i]和B[i]交换的最小交换次数
     * -- 如果A[i] > A[i-1] 且 B[i] > B[i-1]，dp[i][0] = dp[i-1][0] or dp[i-1][1], 看是否交换
     * ************************************************************************************************
     * * 太费劲了DP。。。                                                                                *
     * * 动态规划一般来讲，目标是求什么则什么即为状态，然后分析当前状态和之前状态的推导关系，进而进行穷举所有状态即可。    *
     * ************************************************************************************************
     */
    public int minSwap(int[] A, int[] B) {
        int[][] dp = new int[A.length][2];
        dp[0][0] = 0;
        dp[0][1] = 1;

        for (int i = 1; i < A.length; i++) {
            // 不管前面交换与否
            if (A[i] > A[i - 1] && B[i] > B[i - 1] && A[i] > B[i - 1] && B[i] > A[i - 1]) {
                dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] = dp[i][0] + 1;
                System.out.println("condition1 - " + dp[i][0] + " " + dp[i][1]);
                continue;
            }

            // 可能出现前面换我就不能换，前面不换我就必须换的场景吗?
            // 可能。。。
            if ((A[i] > B[i - 1] && A[i] <= A[i - 1]) || (B[i] > A[i - 1] && B[i] <= B[i - 1])) {
                dp[i][0] = dp[i - 1][1];
                dp[i][1] = dp[i - 1][0] + 1;
                System.out.println("condition2 - " + dp[i][0] + " " + dp[i][1]);
                continue;
            }

            // 否则就是 我和前面得保持一致，一起换或者一起不换
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = dp[i - 1][1] + 1;
            System.out.println("condition3 - " + dp[i][0] + " " + dp[i][1]);
        }
        return Math.min(dp[A.length - 1][0], dp[A.length - 1][1]);
    }

    public static void main(String[] args) {
        int[] A = new int[]{0, 3, 5, 8, 9};
        int[] B = new int[]{2, 1, 4, 6, 9};
        System.out.println(new Number801_DP().minSwap(A, B));
    }
}

