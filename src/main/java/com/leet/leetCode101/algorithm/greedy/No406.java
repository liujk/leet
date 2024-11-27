package com.leet.leetCode101.algorithm.greedy;

import java.util.Arrays;

/**
 * @description
 * @author jkliu
 * @create 2024-11-24 10:09
 **/
public class No406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int length = people.length;
        int[][] ans = new int[length][];
        for (int i = 0; i < length; i++) {
            int space = people[i][1] + 1;
            for (int j = 0; j < length; j++) {
                if (ans[j] == null) {
                    space--;
                }
                if (space == 0) {
                    ans[j] = people[i];
                    break;
                }
            }
        }
        return ans;
    }
}
