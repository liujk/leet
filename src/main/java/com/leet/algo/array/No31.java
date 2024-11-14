package com.leet.algo.array;

import java.util.Arrays;

/**
 * @author jkliu
 * @description
 * @create 2022-08-08 9:03 AM
 **/
public class No31 {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int start = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                start = i;
                break;
            }
        }
        if (start == -1) {
            Arrays.sort(nums);
            return;
        }
        Arrays.sort(nums, start + 1, nums.length);
        for (int i = start + 1; i < nums.length; i++) {
            if (nums[i] > nums[start]) {
                int temp = nums[start];
                nums[start] = nums[i];
                nums[i] = temp;
                return;
            }
        }
    }
}
