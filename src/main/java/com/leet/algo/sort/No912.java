package com.leet.algo.sort;

/**
 * 用归并排序
 * @author jkliu
 * @description
 * @create 2022-07-16 10:06 AM
 **/
public class No912 {
    int[] temp;
    public int[] sortArray(int[] nums) {
        temp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(nums, low, mid);
        sort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            temp[i] = nums[i];
        }
        int i = low, j= mid + 1;
        for (int p = low; p <= high; p++) {
            if (i == mid + 1) {
                nums[p] = temp[j++];
            } else if (j == high + 1) {
                nums[p] = temp[i++];
            } else if (temp[i] > temp[j]) {
                nums[p] = temp[j++];
            } else {
                nums[p] = temp[i++];
            }
        }
    }
}
