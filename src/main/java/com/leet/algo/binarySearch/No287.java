package com.leet.algo.binarySearch;

/**
 * @description
 * @author jkliu
 * @create 2024-12-10 16:15
 **/
public class No287 {
    public int findDuplicate(int[] nums) {
        int left = 1, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                right = mid;
            } else if (count <= mid) {
                left = mid + 1;
            }
        }
        return left;
    }
}
