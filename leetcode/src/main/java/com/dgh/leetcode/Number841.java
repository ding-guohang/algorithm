package com.dgh.leetcode;

import java.util.List;
import java.util.Stack;

import com.google.common.collect.ImmutableList;

/**
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 * <p>
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 * <p>
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 * <p>
 * 你可以自由地在房间之间来回走动。
 * <p>
 * 如果能进入每个房间返回 true，否则返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入: [[1],[2],[3],[]]
 * 输出: true
 * 解释:
 * 我们从 0 号房间开始，拿到钥匙 1。
 * 之后我们去 1 号房间，拿到钥匙 2。
 * 然后我们去 2 号房间，拿到钥匙 3。
 * 最后我们去了 3 号房间。
 * 由于我们能够进入每个房间，我们返回 true。
 * 示例 2：
 * <p>
 * 输入：[[1,3],[3,0,1],[2],[0]]
 * 输出：false
 * 解释：我们不能进入 2 号房间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keys-and-rooms
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 丁国航 Meow on 2020/8/31
 */
public class Number841 {

    /**
     * 从读题来说，感觉这个题目就是遍历外层的list，rooms[0~i]必须包含i+1, 这样才能一直走下去，直到完全包含了rooms.length - 1
     * 以上思考，针对这个输入，发现错了  [[2],[],[1]], 因为我不是非要挨着顺序进去，所以应该是个回溯法？
     * 好像也不对，就是积攒钥匙？ 目前有哪些房间的钥匙，就把对应的房间里的钥匙取出来，直到没有可进入房间为止?
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] keys = new int[rooms.size()];
        Stack<Integer> targetRooms = new Stack<>();
        targetRooms.push(0);
        keys[0] = 1;

        while (!targetRooms.empty()) {
            Integer target = targetRooms.pop();
            rooms.get(target).forEach(k -> {
                if (keys[k] == 1) {
                    return;
                }

                keys[k] = 1;
                targetRooms.push(k);
            });
        }

        for (int k : keys) {
            if (k == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Number841().canVisitAllRooms(ImmutableList.of(ImmutableList.of(1), ImmutableList.of(2), ImmutableList.of(3), ImmutableList.of())));
        System.out.println(new Number841().canVisitAllRooms(ImmutableList.of(ImmutableList.of(2), ImmutableList.of(), ImmutableList.of(1))));
    }
}
