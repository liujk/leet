package com.leet.algo.dp;

/**
 * @author jkliu
 * @description
 * @create 2021-10-28 2:50 PM
 **/
public class No53 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp(dp, nums, i);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    private int dp(int[] dp, int[] nums, int i) {
        if (dp[i] > Integer.MIN_VALUE) {
            return dp[i];
        }
        if (dp(dp, nums, i - 1) >= 0) {
            return dp(dp, nums, i - 1) + nums[i];
        }
        return nums[i];
    }
}
