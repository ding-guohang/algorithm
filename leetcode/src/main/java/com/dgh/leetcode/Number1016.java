package com.dgh.leetcode;

/**
 * 给定一个二进制字符串 S（一个仅由若干 '0' 和 '1' 构成的字符串）和一个正整数 N，如果对于从 1 到 N 的每个整数 X，其二进制表示都是 S 的子串，就返回 true，否则返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "0110", N = 3
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：S = "0110", N = 4
 * 输出：false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-string-with-substrings-representing-1-to-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 丁国航 Meow on 2020/8/31
 */
public class Number1016 {

    public String getString(int N) {
        StringBuilder sb = new StringBuilder();
        while (N > 0) {
            int temp = N / 2;
            int insert = N - temp * 2;
            N = temp;
            sb.insert(0, insert);
        }
        return sb.toString();
    }

    /**
     * 最佳做法应该是二进制的加法，一个一个递推上去判断contains？
     */
    public boolean queryString(String S, int N) {
        for (int i = 0; i <= N; i++) {
            String s = getString(i);
            if (!S.contains(s)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Number1016().getString(15));
    }

}
