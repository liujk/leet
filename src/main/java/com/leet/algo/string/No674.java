package com.leet.algo.string;

/**
 * @author jkliu
 * @description
 * @create 2022-07-28 10:49 AM
 **/
public class No674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int start = 0;
        int len = 0, maxLen = 0;
        int temp = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (temp < nums[i]) {
                len++;
            } else {
                maxLen = Integer.max(maxLen, len);
                start = i;
                len = 1;

            }
            temp = nums[i];
            if ((i + 1) == nums.length) {
                maxLen = Integer.max(maxLen, len);
            }
        }
        return maxLen;
    }
}
