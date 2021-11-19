package com.leet.algo.ques;

import org.springframework.stereotype.Component;

/**
 * @author jkliu
 * @description
 * @create 2020-06-06 20:46
 **/
@Component
public class No53 {
    public int missingNumber(int[] nums) {
        for(int i = 0; i < nums.length; i ++) {
            if (nums[i] > i) {
                return i;
            }
        }
        return nums.length;
    }

    public int missingNumber2(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }

    public static void main(String[] args) {
        byte[] array1 = new byte[1024 * 1024];
        array1 = new byte[1024 * 1024];
        array1 = new byte[1024 * 1024];
        array1 = null;

        byte[] array2 = new byte[2 * 1024 * 1024];
    }
}
