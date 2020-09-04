package com.dgh.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableList;

/**
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 如果存在多种有效的行程，请你按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 * 所有的机票必须都用一次 且 只能用一次。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出：["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 示例 2：
 * <p>
 * 输入：[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reconstruct-itinerary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 丁国航 Meow on 2020/9/1
 */
public class Number332 {

    /**
     * 从JFK开始，逐一遍历所有的可能性，从小遍历到大，成功一种就退出
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> choices = new HashMap<>();
        tickets.forEach(t -> {
            choices.putIfAbsent(t.get(0), new ArrayList<>());
            choices.get(t.get(0)).add(t.get(1));
        });
        choices.keySet().forEach(k -> choices.get(k).sort(String::compareTo));

        List<String> ret = new ArrayList<>();
        find(choices, "JFK", ret);
        return ret;
    }

    private void find(Map<String, List<String>> choices, String key, List<String> ret) {
        List<String> targets = choices.get(key);
        while (null != targets && targets.size() > 0) {
            String target = targets.remove(0);
            find(choices, target, ret);
        }
        ret.add(0, key);
    }

    public static void main(String[] args) {
        // [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
        System.out.println(new Number332().findItinerary(ImmutableList.of(
                ImmutableList.of("MUC", "LHR"),
                ImmutableList.of("JFK", "MUC"),
                ImmutableList.of("SFO", "SJC"),
                ImmutableList.of("LHR", "SFO")
        )));
    }
}
