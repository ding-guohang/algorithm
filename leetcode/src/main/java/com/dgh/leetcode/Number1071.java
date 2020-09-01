package com.dgh.leetcode;

/**
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 * <p>
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * 示例 2：
 * <p>
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * 示例 3：
 * <p>
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/greatest-common-divisor-of-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 丁国航 Meow on 2020/9/1
 */
public class Number1071 {

    public String gcdOfStrings(String str1, String str2) {
        String ret = "";
        String shortStr;
        String longStr;
        if (str1.length() < str2.length()) {
            shortStr = str1;
            longStr = str2;
        } else {
            shortStr = str2;
            longStr = str1;
        }

        for (int i = 1; i <= shortStr.length(); i++) {
            String sub = shortStr.substring(0, i);
            if (fullyDivision(shortStr, sub) && fullyDivision(longStr, sub)) {
                ret = sub;
            }
        }
        return ret;
    }

    private boolean fullyDivision(String str, String sub) {
        if (str.length() % sub.length() != 0) {
            return false;
        }

        int cnt = str.length() / sub.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
            sb.append(sub);
        }
        return sb.toString().equals(str);
    }

    public static void main(String[] args) {
        System.out.println(new Number1071().gcdOfStrings("ABCABC", "ABC"));
    }

}
