package com.dgh.leetcode;


/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 丁国航 Meow on 2020/8/28
 */
public class Number9 {

    public boolean isPalindrome(int x) {
        if (0 <= x && x < 10) {
            return true;
        }

        if (x < 0) {
            return false;
        }

        String y = String.valueOf(x);
        int left = 0;
        int right = y.length() - 1;
        while (true) {
            if (left >= right) {
                return true;
            }

            if (y.charAt(left) != y.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }
    }
}
