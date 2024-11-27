package com.leet.leetCode101.algorithm.greedy;

import java.util.Arrays;

/**
 * @description
 * @author jkliu
 * @create 2024-11-23 15:30
 **/
public class No452 {
    public int findMinArrowShots(int[][] points) {
        int length = points.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return 1;
        }
        Arrays.sort(points, (a, b) -> {
            long result = (long) a[1] - (long) b[1];
            return result < 0 ? -1 : result > 0 ? 1 : 0;
        });
        int left = points[0][0];
        int right = points[0][1];
        int count = 1;
        for (int i = 1; i < length; i++) {
            if (points[i][0] > right) {
                count++;
                left = points[i][0];
                right = points[i][1];
            } else {
                left = Integer.max(left, points[i][0]);
            }
        }
        return count;
    }
}
