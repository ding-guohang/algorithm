package com.dgh.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ImmutableList;

/**
 * 给出方程式 A / B = k, 其中 A 和 B 均为用字符串表示的变量， k 是一个浮点型数字。根据已知方程式求解问题，并返回计算结果。如果结果不存在，则返回 -1.0。
 * <p>
 * 示例 :
 * 给定 a / b = 2.0, b / c = 3.0
 * 问题: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? 
 * 返回 [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * <p>
 * 输入为: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries(方程式，方程式结果，问题方程式)， 其中 equations.size() == values.size()，即方程式的长度与方程式结果长度相等（程式与结果一一对应），并且结果值均为正数。以上为方程式的描述。 返回vector<double>类型。
 * <p>
 * 基于上述例子，输入如下：
 * <p>
 * equations(方程式) = [ ["a", "b"], ["b", "c"] ],
 * values(方程式结果) = [2.0, 3.0],
 * queries(问题方程式) = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 * 输入总是有效的。你可以假设除法运算中不会出现除数为0的情况，且不存在任何矛盾的结果。
 *
 * @author 丁国航 Meow on 2020/9/22
 */
public class Number399_BingChaJi {

    static class Item {
        private final double val;
        private final String s;

        public Item(double val, String s) {
            this.val = val;
            this.s = s;
        }
    }

    /**
     * 这个说是一个典型的 带权并查集 的问题，我其实没懂什么意思
     * 我就尝试穷举来解决一下
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Item>> equation = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> e = equations.get(i);
            equation.putIfAbsent(e.get(0), new ArrayList<>());
            equation.get(e.get(0)).add(new Item(values[i], e.get(1)));

            equation.putIfAbsent(e.get(1), new ArrayList<>());
            equation.get(e.get(1)).add(new Item(1 / values[i], e.get(0)));
        }

        double[] ret = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            if (!equation.containsKey(queries.get(i).get(1))) {
               ret[i] = -1.0d;
               continue;
            }
            Double r = cal(equation, queries.get(i).get(0), queries.get(i).get(1), 1.0d, new HashSet<>());
            ret[i] = null == r ? -1.0d : r;
        }
        return ret;
    }

    private Double cal(Map<String, List<Item>> equations, String current, String target, double val, Set<String> used) {
        if (current.equals(target)) {
            return val;
        }

        List<Item> items = equations.get(current);
        if (null == items) {
            return null;
        }

        for (Item item : items) {
            if (used.contains(item.s)) {
                continue;
            }

            used.add(item.s);
            Double r = cal(equations, item.s, target, val * item.val, used);
            if (null != r) {
                return r;
            }
            used.remove(item.s);
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(new Number399_BingChaJi().calcEquation(
                ImmutableList.of(ImmutableList.of("a", "b"), ImmutableList.of("b", "c")),
                new double[]{2.0, 3.0},
                ImmutableList.of(ImmutableList.of("a", "a")))[0]);
    }
}
