package com.leet.algo.ques;

import java.util.Arrays;

/**
 * @author jkliu
 * @description
 * @create 2021-11-08 3:25 PM
 **/
public class No215 {
    public static int findKthLargest(int[] nums, int k) {
        int res = sort(nums, 0, nums.length - 1, nums.length - k);
        return res == Integer.MAX_VALUE ? nums[nums.length - k] : res;
    }

    private static int sort(int[] nums, int low, int high, int index) {
        int pivot;
        if (low < high) {
            pivot = partition(nums, low, high);
            if (pivot == index) {
                return nums[index];
            }
            int res;
            if (pivot < index) {
                res = sort(nums, pivot + 1, high, index);
            } else {
                res = sort(nums, low, pivot - 1, index);
            }
            if (res != Integer.MAX_VALUE) {
                return res;
            }
        }
        return Integer.MAX_VALUE;
    }

    private static int partition(int[] a, int low, int high) {
        int pivotKey = a[low];

        while (low < high) {
            while (low < high && a[high] >= pivotKey) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= pivotKey) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = pivotKey;
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {7,6,5,4,3,2,1};
        System.out.println(findKthLargest(nums, 2));
    }
}
