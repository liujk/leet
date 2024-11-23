package com.leet.leetCode101.algorithm.greedy;

import java.util.Arrays;

/**
 * @description
 * @author jkliu
 * @create 2024-11-19 11:20
 **/
public class No435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int removed = 0;
        int max = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < max) {
                removed++;
            } else {
                max = intervals[i][1];
            }
        }
        return removed;
    }
}
