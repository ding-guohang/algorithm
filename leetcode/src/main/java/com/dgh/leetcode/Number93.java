package com.dgh.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * <p>
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * <p>
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 * <p>
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 示例 5：
 * <p>
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 丁国航 Meow on 2020/8/31
 */
public class Number93 {

    /**
     * 也只有一个暴力破解的思路，从前往后选出所有可能，然后继续让他往后挑
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        restore(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void restore(String input, int startIndex, List<String> prefix, List<String> result) {
        if (startIndex > input.length()) {
            return;
        }

        if (prefix.size() == 3) {
            String finalStr = input.substring(startIndex);
            if (!isSuitIp(finalStr)) {
                return;
            }
            List<String> ret = new ArrayList<>(prefix);
            ret.add(finalStr);
            result.add(dealResult(ret));
            return;
        }

        for (int k = 1; k <= 3; k++) {
            if (startIndex + k <= input.length() && isSuitIp(input.substring(startIndex, startIndex + k))) {
                ArrayList<String> pre = new ArrayList<>(prefix);
                pre.add(input.substring(startIndex, startIndex + k));
                restore(input, startIndex + k, pre, result);
            }
        }

    }

    private boolean isSuitIp(String input) {
        if ("".equals(input)) {
            return false;
        }
        if ("0".equals(input)) {
            return true;
        }

        if (input.startsWith("0")) {
            return false;
        }

        if (input.length() > 3) {
            return false;
        }

        return Integer.parseInt(input) <= 255;
    }

    private String dealResult(List<String> input) {
        StringBuilder sb = new StringBuilder();
        sb.append(input.get(0));

        for (int i = 1; i < 4; i++) {
            sb.append(".").append(input.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "101023";
        System.out.println(new Number93().restoreIpAddresses(s));
    }
}
