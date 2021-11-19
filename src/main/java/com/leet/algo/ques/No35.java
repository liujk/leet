package com.leet.algo.ques;

import org.springframework.stereotype.Component;

/**
 * @author jkliu
 * @description
 * @create 2019-06-04 22:29
 **/
@Component
public class No35 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            } else if (nums[i] > target) {
                return i;
            }
        }
        return nums.length;
    }
}
