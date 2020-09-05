package com.dgh.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * <p>
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 丁国航 Meow on 2020/9/5
 */
public class Number60 {

    /**
     * 忽略数学的算法，直接用回溯法强行解答一下
     * def dfs(n){                         //可以描述阶段的状态
     * if(valid) {收集结果，返回}	        //出口条件
     * if(pruning) return;             //剪枝，这一步是为了加快回溯过程，降低程序执行时间
     * for(i:1~p){                      //选择该阶段的所有决策
     * 选择可行决策;                   //剪枝的一种
     * add;						  //标记已访问该点
     * DFS(n+1);                     //进入下一阶段
     * recover;                      //还原
     * }
     * }
     */
    public String getPermutation(int n, int k) {
        Set<Integer> used = new HashSet<>();
        AtomicInteger cnt = new AtomicInteger(0);
        List<Integer> result = new ArrayList<>();
        find(n, k, used, cnt, result);

        StringBuilder sb = new StringBuilder();
        result.forEach(sb::append);
        return sb.toString();
    }

    private boolean find(int n, int k, Set<Integer> used, AtomicInteger count, List<Integer> ret) {
        if (ret.size() == n) {
            int cnt = count.incrementAndGet();
            return cnt == k;
        }
        for (int i = 1; i <= n; i++) {
            if (used.add(i)) {
                ret.add(i);
                // 时间超出长度了，要考虑在这里剪去枝桠
                int total = cal(n - ret.size());
                if (count.get() + total < k) {
                    // 把当前这个值选中之后，遍历完所有节点也不够达到k
                    used.remove(i);
                    count.addAndGet(total);
                    ret.remove(ret.size() - 1);
                    continue;
                }

                boolean found = find(n, k, used, count, ret);
                if (found) {
                    return true;
                }

                ret.remove(ret.size() - 1);
                used.remove(i);
            }
        }
        return false;
    }

    private int cal(int n) {
        int ret = 1;
        for (int i = 1; i <= n; i++) {
            ret = ret * i;
        }
        return ret;
    }


    public static void main(String[] args) {
        System.out.println(new Number60().getPermutation(3, 3));
    }
}
