package com.leet.leetCode101.algorithm.greedy;

/**
 * @description
 * @author jkliu
 * @create 2024-11-24 11:02
 **/
public class No665 {
    public boolean checkPossibility(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return true;
        }
        int changeCount = 0;
        for (int i = 0; i < length -1; i++) {
            int x = nums[i];
            int y = nums[i+1];
            if (x > y) {
                changeCount++;
                if (changeCount > 1) {
                    return false;
                }
                if (i > 0 && y < nums[i - 1]) {
                    nums[i + 1] = x;
                }
            }
        }
        return true;
    }
}
