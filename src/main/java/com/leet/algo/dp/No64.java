package com.leet.algo.dp;

/**
 * @author jkliu
 * @description
 * @create 2021-11-01 11:01 AM
 **/
public class No64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Integer.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }

//    public int minPathSum(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//
//        int[][] dp = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                dp[i][j] = -1;
//            }
//        }
//        dp[0][0] = grid[0][0];
//        for (int i = 1; i < m; i++) {
//            dp[i][0] = dp[i-1][0] + grid[i][0];
//        }
//        for (int i = 1; i < n; i++) {
//            dp[0][i] = dp[0][i-1] + grid[0][i];
//        }
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                dp[i][j] = sum(dp, grid, i, j);
//            }
//        }
//        return dp[m-1][n-1];
//    }
//
//    private int sum(int[][] dp, int[][] grid, int m, int n) {
//        if (dp[m][n] > -1) {
//            return dp[m][n];
//        }
//        return Integer.min(sum(dp, grid, m-1, n), sum(dp, grid, m, n-1)) + grid[m][n];
//    }
}
