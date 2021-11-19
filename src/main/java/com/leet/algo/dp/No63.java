package com.leet.algo.dp;

/**
 * @author jkliu
 * @description
 * @create 2021-11-01 2:21 PM
 **/
public class No63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[m - 1];
    }
}
