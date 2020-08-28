package com.dgh.leetcode;

/**
 * @author 丁国航 Meow on 2020/8/28
 */
public class Number657 {

    private static void move(char m, int[] coordinate) {
        switch (m) {
            case 'R':
                coordinate[1]++;
                break;
            case 'L':
                coordinate[1]--;
                break;
            case 'U':
                coordinate[0]++;
                break;
            case 'D':
                coordinate[0]--;
                break;
            default:
                throw new RuntimeException("error move action");
        }
    }

    public boolean judgeCircle(String moves) {
        int[] coordinate = new int[]{0, 0};
        for (char m : moves.toCharArray()) {
            move(m, coordinate);
        }

        return coordinate[0] == 0 && coordinate[1] == 0;
    }
}
