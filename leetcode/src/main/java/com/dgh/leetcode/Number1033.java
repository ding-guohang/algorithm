package com.dgh.leetcode;

import java.util.Arrays;

/**
 * 三枚石子放置在数轴上，位置分别为 a，b，c。
 * <p>
 * 每一回合，我们假设这三枚石子当前分别位于位置 x, y, z 且 x < y < z。从位置 x 或者是位置 z 拿起一枚石子，并将该石子移动到某一整数位置 k 处，其中 x < k < z 且 k != y。
 * <p>
 * 当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。
 * <p>
 * 要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximum_moves]
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = 1, b = 2, c = 5
 * 输出：[1, 2]
 * 解释：将石子从 5 移动到 4 再移动到 3，或者我们可以直接将石子移动到 3。
 * 示例 2：
 * <p>
 * 输入：a = 4, b = 3, c = 2
 * 输出：[0, 0]
 * 解释：我们无法进行任何移动。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/moving-stones-until-consecutive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 丁国航 Meow on 2020/9/7
 */
public class Number1033 {

    /**
     * 这个题意让我稍微有点晕，最小次数不是一定等于0，1，2么
     * 最大的话，就是间隔数？
     * ----
     * 提交了几次才反应过来，c可以移动到a和b中间的, 所以最小值还要商榷
     */
    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);
        a = arr[0];
        b = arr[1];
        c = arr[2];

        int min = calMin(a, b, c);

        int max = 0;
        max += (c - b - 1);
        max += (b - a - 1);
        return new int[] {min, max};
    }

    private int calMin(int a, int b, int c) {
        if (a + 1 == b && b + 1 == c) {
            return 0;
        }

        int min = 0;
        if (b - a > 1) {
           min++;
        }
        if (c - b > 1) {
            min++;
        }
        if (min == 2) {
            if (b - a == 2 || c - b == 2) {
                return 1;
            }
        }
        return min;
    }
}
