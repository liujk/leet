package com.leet.algo.dp;

/**
 * @author jkliu
 * @description
 * @create 2021-10-27 2:22 PM
 **/
public class No5 {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        if (s.length() == 2) {
            return s.charAt(0) == s.charAt(1) ? s : s.substring(0, 1);
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        int start = 0;
        int maxLen = 1;

        for (int l = 2; l <= s.length(); l++) {
            for (int i = 0; i < s.length(); i++) {
                int j = i + l - 1;
                if (j >= s.length()) {
                    break;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else if (j - i < 3) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i+1][j-1];
                }
                if (dp[i][j] && l > maxLen) {
                    start = i;
                    maxLen = l;
                }

            }
        }
        return s.substring(start, start + maxLen);
    }

    @Deprecated
    public String longestPalindrome2(String s) {
        if (s.length() == 1) {
            return s;
        }
        if (s.length() == 2) {
            return s.charAt(0) == s.charAt(1) ? s : s.substring(0, 1);
        }
        int[] dp = new int[s.length() + 1];
        dp[1] = 1;
        for (int i = 3; i <= s.length(); i++) {
            dp[i] = dp(s, i);
        }
        return null;
    }

    private int dp(String s, int i) {
        int temp = dp(s, i-1);
        if (i - 2 - temp < 0) {
            return temp;
        }
        if (s.charAt(i - 2 - temp) == s.charAt(i-1)) {
            return dp(s, i - 1) + 2;
        }
        return temp;
    }
}
