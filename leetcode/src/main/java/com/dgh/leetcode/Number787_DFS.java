package com.dgh.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 有 n 个城市通过 m 个航班连接。每个航班都从城市 u 开始，以价格 w 抵达 v。
 * <p>
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到从 src 到 dst 最多经过 k 站中转的最便宜的价格。 如果没有这样的路线，则输出 -1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * 输出: 200
 * 解释:
 * 城市航班图如下
 * <p>
 * <p>
 * 从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。
 * 示例 2：
 * <p>
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * 输出: 500
 * 解释:
 * 城市航班图如下
 * <p>
 * <p>
 * 从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500，如图中蓝色所示。
 *  
 * <p>
 * 提示：
 * <p>
 * n 范围是 [1, 100]，城市标签从 0 到 n - 1.
 * 航班数量范围是 [0, n * (n - 1) / 2].
 * 每个航班的格式 (src, dst, price).
 * 每个航班的价格范围是 [1, 10000].
 * k 范围是 [0, n - 1].
 * 航班没有重复，且不存在环路
 *
 * @author 丁国航 Meow on 2020/9/19
 */
public class Number787_DFS {

    static class Flight {
        private final int src;
        private final int dst;
        private final int price;

        public Flight(int src, int dst, int price) {
            this.src = src;
            this.dst = dst;
            this.price = price;
        }
    }

    // 看题目像是dfs
    // fight = [src,dst,price],src,dst,price = fight[0],fight[1],fight[2]
    // 是DP
    // 是DP吗。。我的反应是从src开始，遍历所有路径，到dst结束 或者 到K结束，计算出来所有价格
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        AtomicInteger minPrice = new AtomicInteger(Integer.MAX_VALUE);
        Map<Integer, List<Flight>> allFlights = new HashMap<>();
        for (int[] flight : flights) {
            allFlights.putIfAbsent(flight[0], new ArrayList<>());
            allFlights.get(flight[0]).add(new Flight(flight[0], flight[1], flight[2]));
        }

        dfs(src, dst, K, minPrice, allFlights, 0);
        return minPrice.get() != Integer.MAX_VALUE ? minPrice.get() : -1;
    }

    private void dfs(int src, int dst, int cnt, AtomicInteger minPrice, Map<Integer, List<Flight>> flights, int currentPrice) {
        if (cnt < 0) {
            return;
        }

        if (currentPrice > minPrice.get()) {
            return;
        }

        List<Flight> available = flights.get(src);
        if (null == available) {
            return;
        }
        cnt--;
        for (Flight flight : available) {
            if (flight.dst == dst) {
                if (currentPrice + flight.price < minPrice.get()) {
                    minPrice.set(currentPrice + flight.price);
                }
                continue;
            }

            dfs(flight.dst, dst, cnt, minPrice, flights, currentPrice + flight.price);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Number787_DFS().findCheapestPrice(
                3,
                new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}},
                0,
                2,
                1));
    }
}
