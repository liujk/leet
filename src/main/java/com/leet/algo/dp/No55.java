package com.leet.algo.dp;

/**
 * @author jkliu
 * @description
 * @create 2021-10-28 3:38 PM
 **/
public class No55 {

    public boolean canJump2(int[] nums) {
        if (nums.length == 1 || nums[0] == 0) {
            return true;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != 0) {
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (nums[j] > i - j) {
                    break;
                }
                if (j == (i-1)) {
                    return false;
                }
            }
        }
        return true;
    }
}
