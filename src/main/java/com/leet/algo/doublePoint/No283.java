package com.leet.algo.doublePoint;

/**
 * @description
 * @author jkliu
 * @create 2024-11-30 14:48
 **/
public class No283 {
    public void moveZeroes(int[] nums) {
        int s = 0, p = 0;
        while (p < nums.length) {
            if (nums[p] != 0) {
                nums[s] = nums[p];
                s++;
            }
            p++;
        }
        while (s < nums.length) {
            nums[s] = 0;
            s++;
        }
    }
}
