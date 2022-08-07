package com.leet.algo.other;

/**
 * @author jkliu
 * @description
 * @create 2022-07-30 5:10 PM
 **/
public class No994 {
    public int orangesRotting(int[][] grid) {
        int min = 0;
        int count = 0, total = 0, last = 0;
        for (int m = 0; m < grid.length; m++) {
            for (int n = 0; n < grid[0].length; n++) {
                if (grid[m][n] == 2) {
                    count++;
                }
                if (grid[m][n] > 0) {
                    total++;
                }
            }
        }
        if (count == total) {
            return 0;
        }
        if (count == 0) {
            return -1;
        }

        while (count != last) {
            for (int m = 0; m < grid.length; m++) {
                for (int n = 0; n < grid[0].length; n++) {
                    if (grid[m][n] == 2) {
                        if ()
                    }
                }
            }
        }
    }
}
