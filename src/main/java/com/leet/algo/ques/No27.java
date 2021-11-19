package com.leet.algo.ques;

import org.springframework.stereotype.Component;

/**
 * @author jkliu
 * @description
 * @create 2019-06-04 22:16
 **/
@Component
public class No27 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = (nums[0] == val ? 1 : 0);
        for (int i = 1; i < nums.length; i++) {
            nums[i-len] = nums[i];
            if (nums[i] == val) {
                len++;
            }
        }
        return nums.length - len;
    }
}
