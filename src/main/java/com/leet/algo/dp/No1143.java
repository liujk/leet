package com.leet.algo.dp;

import java.util.Arrays;

/**
 * @author jkliu
 * @description
 * @create 2022-08-08 9:49 PM
 **/
public class No1143 {
    int[][] mem = null;
    public int longestCommonSubsequence(String text1, String text2) {
        mem = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                mem[i][j] =  -1;
            }
        }
        return dp(text1, 0, text2, 0);
    }

    private int dp(String text1, int i, String text2, int j) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if (mem[i][j] != -1) {
            return mem[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            mem[i][j] = 1 + dp(text1, i  + 1, text2, j + 1);
        } else {
            mem[i][j] = Integer.max(dp(text1, i + 1, text2, j), dp(text1, i, text2, j + 1));
        }
        return mem[i][j];
    }


    public int longestCommonSubsequence2(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Integer.max(dp[i][j - 1],  dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
