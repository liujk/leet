package com.leet.algo.dp;

import java.util.Arrays;

/**
 * @author jkliu
 * @description
 * @create 2022-08-10 9:31 AM
 **/
public class No712 {
    int[][] mem = null;
    public int minimumDeleteSum(String s1, String s2) {
        mem = new int[s1.length()][s2.length()];
        for (int i = 0; i < mem.length; i++) {
            Arrays.fill(mem[i], -1);
        }
        return dp(s1, 0, s2, 0);
    }

    private int dp(String s1, int i, String s2, int j) {
        if (i == s1.length()) {
            mem[i][j] = 0;
            for (; j < s2.length(); j++) {
                mem[i][j] += s2.charAt(j);
            }
            return mem[i][j];
        }
        if (j == s2.length()) {
            mem[i][j] = 0;
            for (; i < s1.length(); i++) {
                mem[i][j] +=s1.charAt(i);
            }
            return mem[i][j];
        }
        if (mem[i][j] != -1) {
            return mem[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            mem[i][j] = dp(s1, i + 1, s2, j + 1);
        } else {
            mem[i][j]  = Integer.min(s1.charAt(i) + dp(s1,i + 1, s2, j), s2.charAt(j) + dp(s1, i, s2, j + 1));
        }
        return mem[i][j];
    }
}
