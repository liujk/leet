package com.leet.algo.dp;


import java.util.Arrays;

/**
 *
 *
 * @create 2022-02-19 6:31 PM
 **/
public class No673 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        int[] dpNum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            dpNum[i] = 1;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] == dp[j] + 1) {
                        dpNum[i] = dpNum[i] + dpNum[j];
                    } else if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        dpNum[i] = dpNum[j];
                    }
                }
            }
        }

        int num = 0;
        int total = 0;
        for (int i = dp.length - 1; i >=0 ; i--) {
            if (dp[i] > num) {
                num = dp[i];
                total = dpNum[i];
            } else if (dp[i] == num) {
                total = total + dpNum[i];
            }
        }
        return total;
    }
}
