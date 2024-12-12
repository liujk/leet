package com.leet.algo.doublePoint;

/**
 * @description
 * @author jkliu
 * @create 2024-12-10 16:15
 **/
public class No287 {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow!= fast);

        int ptr = 0;
        while (ptr!= slow) {
            ptr = nums[ptr];
            slow = nums[slow];
        }

        return ptr;
    }
}
