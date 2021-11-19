package com.leet.algo.ques;

import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author jkliu
 * @description
 * @create 2019-06-04 23:00
 **/
@Component
public class No31 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int firstLowIndex = -1;
        for (int i = nums.length -2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                firstLowIndex = i;
                break;
            }
        }
        if (firstLowIndex == -1) {
            Arrays.sort(nums);
        }
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[firstLowIndex]) {
                int temp = nums[i];
                nums[i] = nums[firstLowIndex];
                nums[firstLowIndex] = temp;
                break;
            }
        }
        Arrays.sort(nums, firstLowIndex+1, nums.length);
    }
}
